/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.model.orders.Order;
import sample.model.orders.OrderDetail;
import sample.model.payment.DeliveryShipping;
import sample.model.product.Cart;
import sample.model.product.Category;
import sample.model.product.Product;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
public class ProductDAO {

    private static final String INSERT_CATEGORY = "INSERT INTO Category (name, dateCreate) values (?, GETDATE())";
    private static final String INSERT_PRODUCT = "INSERT INTO Product (name, price, quantity,description, img, idCategory,dateCreate,isActive,sold) VALUES (?,?,?,?,?,?,GETDATE(),1,0)";
    private static final String GET_CATEGORY_BY_ID = "SELECT c.id, c.name FROM Category AS c WHERE C.id=? ";
    private static final String GET_ALL_CATEGORY = "SELECT c.id, c.name FROM Category AS c";
    private static final String GET_ALL_PRODUCT = "SELECT * FROM Product";
    private static final String SELECT_TOP4_BEST_SALER = "SELECT TOP 4 * FROM Product ORDER BY sold DESC";
    private static final String SELECT_TOP3_BEST_SALER = "SELECT TOP 3 * FROM Product ORDER BY sold DESC";
    private static final String SELECT_TOP3_NEW = "SELECT TOP 3 * FROM Product ORDER BY dateCreate DESC";
    private static final String SELECT_TOP3_CHEAP = "SELECT TOP 3 * FROM Product ORDER BY price ASC";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE id=? ";
    private static final String SEARCH_BY_KEYWORD = "SELECT * FROM product AS p join Category AS c ON p.idCategory=c.id WHERE p.name LIKE ? OR c.name LIKE ?";
    private static final String SEARCH_PRODUCT_BY_KEYWORD = "SELECT * FROM product AS p WHERE p.name LIKE ? ";
    private static final String GET_PRODUCT_BY_CATEGORY_ID = "SELECT * FROM PRODUCT WHERE idCategory=? ";
    private static final String GET_PRODUCT_BY_PRICE = "SELECT * FROM Product WHERE  price >? AND price <?  ";
    private static final String GET_PRODUCT_BY_PRICE_OVER = "SELECT * FROM Product WHERE  price >? ";
    private static final String UPDATE_QUANTITY_PRODUCT = "UPDATE Product SET quantity =?, sold=? WHERE id=?";
    private static final String INSERT_ORDER = "INSERT INTO [Orders](username, totalMoney,dateCreate,status) VALUES(?,?,GETDATE(),0)";
    private static final String INSERT_ORDERDETAIL = "INSERT INTO OrderDetail(orderId,productId,quantity,price,tax,shipping,phone,address,name,email) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final double SHIPPING = 5.00;
    private static final double TAX = 10.00;
    private static final String GET_NEW_ORDER = "SELECT * FROM [Orders] WHERE status=0 ";
    private static final String GET_ALL_ORDER = "SELECT * FROM [Orders]";
    private static final String SEARCH_ORDERS = "SELECT * FROM [Orders] WHERE id=? OR username LIKE ?";
    private static final String SEARCH_ORDERS_STATUS_NEW = "SELECT * FROM [Orders] WHERE status=0 AND (id=? OR username LIKE ? )";
    private static final String SET_STATUS_ORDER = "UPDATE [Orders] SET status=1 WHERE id=?";
    private static final String GET_ORDER_DETAIL_BY_ORDERID = "SELECT * FROM OrderDetail WHERE orderId=?";
    private static final String GET_CATEGORY_BY_NAME = "SELECT * FROM Category WHERE name LIKE ?";
    private static final String UPDATE_PRODUCT = "UPDATE Product SET name=?, idCategory=?,quantity=?,price=?,description=?,img=?,isActive=?,lastupdate=GETDATE() WHERE id=?";
    

    public List<Product> SearchProductByName(String name) throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SEARCH_PRODUCT_BY_KEYWORD);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")), rs.getInt("sold"), rs.getBoolean("isactive"));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchProductByName with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public boolean InsertCategory(String name) throws ClassNotFoundException {
        List<Category> listCategory = new ArrayList<>();
        boolean check = false;
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_CATEGORY);
            st.setString(1, name);
            check = st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at InsertCategory with ERROR: " + e.toString());
        }
        return check;
    }

    public Category GetCategoryById(int id) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_CATEGORY_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                return category;
            }
        } catch (SQLException e) {
            System.out.println("Error at GetCategoryById with ERROR: " + e.toString());
        }
        return null;
    }

    public boolean InsertProduct(Product p) throws ClassNotFoundException {
        boolean check = false;
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_PRODUCT);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setString(4, p.getDescription());
            st.setString(5, p.getImg());
            st.setInt(6, p.getCategory().getId());
            check = st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at InsertProduct with ERROR: " + e.toString());
        }
        return check;
    }

    public List<Category> GetAllCategory() throws ClassNotFoundException {
        List<Category> listCategory = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_CATEGORY);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("name"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetAllCategory with ERROR: " + e.toString());
        }
        return listCategory;
    }

    public List<Product> GetAllProduct() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_PRODUCT);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetAllProduct with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetAllProductWithStatus() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_PRODUCT);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")),rs.getInt("sold"), rs.getBoolean("isactive"));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetAllProduct with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetTop4BestSaler() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SELECT_TOP4_BEST_SALER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetTop4BestSaler with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetTop3BestSaler() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SELECT_TOP3_BEST_SALER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetTop4BestSaler with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetTop3New() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SELECT_TOP3_NEW);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetTop4BestSaler with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetTop3Cheap() throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SELECT_TOP3_CHEAP);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetTop4BestSaler with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public Product GetProductById(int id) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_PRODUCT_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error at GetProductById with ERROR: " + e.toString());
        }
        return null;
    }

    public Product GetProductByIdWithStatus(int id) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_PRODUCT_BY_ID);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")), rs.getInt("sold"), rs.getBoolean("isactive"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error at GetProductById with ERROR: " + e.toString());
        }
        return null;
    }

    public List<Product> SearchProductByKeyWord(String keyword1) throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SEARCH_BY_KEYWORD);
            st.setString(1, "%" + keyword1 + "%");
            st.setString(2, "%" + keyword1 + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchProductByKeyWord with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetProductByCategoryId(int idCate) throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_PRODUCT_BY_CATEGORY_ID);
            st.setInt(1, idCate);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetProductByCategoryId with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> GetProductByPrice(double froms, double tos) throws ClassNotFoundException {
        List<Product> listProduct = new ArrayList<>();
        PreparedStatement st = null;
        try {
            if (tos < 0) {
                st = DBUtils.getConnection().prepareStatement(GET_PRODUCT_BY_PRICE_OVER);
                st.setDouble(1, froms);
            } else {
                st = DBUtils.getConnection().prepareStatement(GET_PRODUCT_BY_PRICE);
                st.setDouble(1, froms);
                st.setDouble(2, tos);
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("description"), rs.getString("img"), GetCategoryById(rs.getInt("idCategory")));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetProductByPrice with ERROR: " + e.toString());
        }
        return listProduct;
    }

    public List<Product> PaginationProduct(List<Product> listP, int start, int end) {
        List<Product> listProduct = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listProduct.add(listP.get(i));
        }
        return listProduct;
    }

    public Boolean InsertOrder(Cart cart, User user, DeliveryShipping deliveryShipping) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_ORDER);
            st.setString(1, user.getUsername());
            st.setDouble(2, cart.GetTotal());
            if (st.executeUpdate() > 0) {
                PreparedStatement st01 = DBUtils.getConnection().prepareStatement("SELECT TOP 1 id FROM [Orders] ORDER BY id DESC");
                ResultSet rs = st01.executeQuery();
                if (rs.next()) {
                    int idOrder = rs.getInt("id");
                    if (InsertOrderDetail(cart, idOrder, deliveryShipping)) {
                        return UpdateProduct(cart);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at InsertOrder with ERROR: " + e.toString());
        }
        return false;
    }

    public Boolean UpdateProduct(Cart cart) throws ClassNotFoundException {
        Boolean check = false;
        try {
            for (Product value : cart.getMapCart().values()) {
                PreparedStatement st00 = DBUtils.getConnection().prepareStatement("SELECT p.sold FROM Product AS p WHERE id=?");
                st00.setInt(1, value.getId());
                ResultSet rs00 = st00.executeQuery();
                if (rs00.next()) {
                    int sold = 0;
                    if (rs00.wasNull()) {
                        sold = 0;
                    } else {
                        sold = rs00.getInt("sold");
                    }
                    PreparedStatement st = DBUtils.getConnection().prepareStatement(UPDATE_QUANTITY_PRODUCT);
                    st.setDouble(1, GetProductById(value.getId()).getQuantity() - value.getQuantity());
                    st.setInt(2, sold + value.getQuantity());
                    st.setInt(3, value.getId());
                    check = st.executeUpdate() > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at UpdateProduct with ERROR: " + e.toString());
        }
        return check;
    }

    public Boolean InsertOrderDetail(Cart cart, int ordersId, DeliveryShipping deliveryShipping) throws ClassNotFoundException {
        Boolean check = true;
        try {
            for (Product value : cart.getMapCart().values()) {
                PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_ORDERDETAIL);
                st.setInt(1, ordersId);
                st.setInt(2, value.getId());
                st.setInt(3, value.getQuantity());
                st.setDouble(4, value.getPrice());
                st.setDouble(5, TAX);
                st.setDouble(6, SHIPPING);
                st.setString(7, deliveryShipping.getPhone());
                st.setString(8, deliveryShipping.getAddress());
                st.setString(9, deliveryShipping.getFirstName() + deliveryShipping.getLastName());
                st.setString(10, deliveryShipping.getEmail());
                check = st.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error at InsertOrderDetail with ERROR: " + e.toString());
        }
        return check;
    }

    public List<Order> GetOrderWithStatusNew() throws ClassNotFoundException {
        UserDAO uDAO = new UserDAO();
        List<Order> listOrder = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_NEW_ORDER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("status") == false) {
                    Order order = new Order(rs.getInt("id"), uDAO.GetUserByUsername(rs.getString("username")), rs.getDouble("totalMoney"), rs.getDate("dateCreate"), rs.getBoolean("status"));
                    listOrder.add(order);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at GetOrderWithStatusNew with ERROR: " + e.toString());
        }
        return listOrder;
    }

    public List<Order> GetAllOrder() throws ClassNotFoundException {
        UserDAO uDAO = new UserDAO();
        List<Order> listOrder = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_ORDER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"), uDAO.GetUserByUsername(rs.getString("username")), rs.getDouble("totalMoney"), rs.getDate("dateCreate"), rs.getBoolean("status"));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetOrderWithStatusNew with ERROR: " + e.toString());
        }
        return listOrder;
    }

    public List<Order> PaginationOrder(List<Order> listOrder, int start, int end) {
        List<Order> listOrderPaging = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listOrderPaging.add(listOrder.get(i));
        }
        return listOrderPaging;
    }

    public List<Order> SearchOrders(String search) throws ClassNotFoundException {
        List<Order> listOrder = new ArrayList<>();
        UserDAO uDAO = new UserDAO();
        int parseInt = 0;
        if (TryParseInteger(search)) {
            parseInt = Integer.parseInt(search);
        } else {
            parseInt = 0;
        }
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SEARCH_ORDERS);
            st.setInt(1, parseInt);
            st.setString(2, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"), uDAO.GetUserByUsername(rs.getString("username")), rs.getDouble("totalMoney"), rs.getDate("dateCreate"), rs.getBoolean("status"));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchOrders with ERROR: " + e.toString());
        }
        return listOrder;
    }

    public List<Order> SearchOrdersWithStatusNews(String search) throws ClassNotFoundException {
        List<Order> listOrder = new ArrayList<>();
        UserDAO uDAO = new UserDAO();
        int parseInt = 0;
        if (TryParseInteger(search)) {
            parseInt = Integer.parseInt(search);
        } else {
            parseInt = 0;
        }
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SEARCH_ORDERS_STATUS_NEW);
            st.setInt(1, parseInt);
            st.setString(2, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"), uDAO.GetUserByUsername(rs.getString("username")), rs.getDouble("totalMoney"), rs.getDate("dateCreate"), rs.getBoolean("status"));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchOrders with ERROR: " + e.toString());
        }
        return listOrder;
    }

    private Boolean TryParseInteger(String s) {
        try {
            if (s.split(" ").length == 1) {
                int i = Integer.parseInt(s.split(" ")[0]);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean SetStatusOrder(int idorder) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SET_STATUS_ORDER);
            st.setInt(1, idorder);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at SetStatusOrder with ERROR: " + e.toString());
        }
        return false;
    }

    public List<OrderDetail> GetOrderDetailByOrderId(int orderid) throws ClassNotFoundException {
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ORDER_DETAIL_BY_ORDERID);
            st.setInt(1, orderid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DeliveryShipping deliveryShipping = new DeliveryShipping(rs.getString("name"), "", rs.getString("email"), rs.getString("phone"), rs.getString("address"));
                OrderDetail orderDetail = new OrderDetail(rs.getInt("orderId"), GetProductById(rs.getInt("productId")), rs.getInt("quantity"), rs.getDouble("price"), TAX, SHIPPING, deliveryShipping);
                listOrderDetail.add(orderDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetOrderDetailByOrderId with ERROR: " + e.toString());
        }
        return listOrderDetail;
    }

    public List<Category> GetCategoryByName(String name) throws ClassNotFoundException {
        List<Category> listCate = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_CATEGORY_BY_NAME);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listCate.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println("Error at GetCategoryByName with ERROR: " + e.toString());
        }
        return listCate;
    }

    public List<Category> PaginationCategory(List<Category> listCate, int start, int end) {
        List<Category> listCateNew = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listCateNew.add(listCate.get(i));
        }
        return listCateNew;
    }

    public Boolean UpdateProduct(Product p) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(UPDATE_PRODUCT);
            st.setString(1, p.getName());
            st.setInt(2, p.getCategory().getId());
            st.setInt(3, p.getQuantity());
            st.setDouble(4, p.getPrice());
            st.setString(5, p.getDescription());
            st.setString(6, p.getImg());
            st.setBoolean(7, p.isIsActive());
            st.setInt(8, p.getId());
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at UpdateProduct with ERROR: " + e.toString());
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ProductDAO pDAO = new ProductDAO();
//        Category category = p.GetCategoryById(1);
//        // Product pro = new Product(1, "Black Air", 200.00, 100, "Very beautiful !!", "none",category );
//        System.out.println(p.GetProductByPrice(400, -1).size());
//        UserDAO uDAO = new UserDAO();
//        ProductDAO pDAO = new ProductDAO();
        Map<Integer, Product> mapCart = new HashMap<>();
        Product p00 = pDAO.GetProductById(1);
        Product p01 = pDAO.GetProductById(2);
        mapCart.put(1, p00);
        mapCart.put(2, p01);
        Cart cart = new Cart(mapCart);
//        User u = uDAO.GetUserByUsername("nguyen");
//        System.out.println(pDAO.InsertOrder(cart, u));
        Category c = pDAO.GetCategoryById(1);
        Product pp = new Product(33, "tao ne", 450.00, 10, "cai loz ma", "lozzzz", c, 12, false);
        System.out.println(pDAO.UpdateProduct(pp));
    }

}
