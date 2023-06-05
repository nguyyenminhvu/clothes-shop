/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "ErrorJSP.jsp";
    private static final String CREATE_CATEGORY = "CreateCategory";
    private static final String CREATE_CATEGORY_PAGE = "CreateCategoryController";
    private static final String CREATE_PRODUCT = "CreateProduct";
    private static final String CREATE_PRODUCT_PAGE = "CreateProductController";
    private static final String LOGIN = "Login";
    private static final String LOGIN_PAGE = "LoginController";
    private static final String SIGNUP = "SignUp";
    private static final String SIGNUP_PAGE = "SignUpController";
    private static final String DETAIL_PRODUCT = "DetailProduct";
    private static final String DETAIL_PRODUCT_PAGE = "DetailProductController";
    private static final String LOAD_SHOP = "LoadShop";
    private static final String LOAD_SHOP_PAGE = "LoadShopController";
    private static final String REMOVE_USER = "Remove";
    private static final String REMOVE_USER_PAGE = "RemoveController";
    private static final String SEARCH_USER = "Search";
    private static final String SEARCH_USER_PAGE = "UserManagementController";
    private static final String EMPLOYEE_UPDATE_USER = "EmployeeUpdateUser";
    private static final String EMPLOYEE_UPDATE_USER_PAGE = "EmployeeUpdateUserController";
    private static final String ADD_TO_CART = "AddToCart";
    private static final String ADD_TO_CART_PAGE = "CartController";
    private static final String PROCESS_CART = "ProcessCart";
    private static final String PROCESS_CART_PAGE = "CartProcessController";
    private static final String DETAIL_CART = "DetailCart";
    private static final String DETAIL_CART_PAGE = "LoadDetailCartController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_PAGE = "LogoutController";
    private static final String DELIVERY_CHECKOUT = "Delivery";
    private static final String DELIVERY_CHECKOUT_PAGE = "DeliveryCheckoutController";
    private static final String DELIVERY_CHECKOUT_FORM = "Form";
    private static final String DELIVERY_CHECKOUT_FORM_PAGE = "DeliveryForm.jsp";
    private static final String ALL_ORDERS = "AllOrders";
    private static final String ALL_ORDERS_PAGE = "AllOrdersController";
    private static final String NEW_ORDERS = "NewOrders";
    private static final String NEW_ORDERS_PAGE = "NewOrdersController";
    private static final String SEARCH_ORDER_BY_USERNAME_ORDERSID = "SearchOrder";
    private static final String SEARCH_ORDER_BY_USERNAME_ORDERSID_PAGE = "AllOrdersController";
    private static final String SET_STATUS_ORDER = "SetStatusOrder";
    private static final String SET_STATUS_ORDER_PAGE = "SetStatusOrderController";
    private static final String SEARCH_ORDER_BY_USERNAME_ORDERSID_STATUS_NEW = "SearchOrderNew";
    private static final String SEARCH_ORDER_BY_USERNAME_ORDERSID_STATUS_NEW_PAGE = "NewOrdersController";
    private static final String ORDER_DETAIL = "OrderDetail";
    private static final String ORDER_DETAIL_PAGE = "OrderDetailController";
    private static final String ALL_CATEGORY = "AllCategory";
    private static final String ALL_CATEGORY_PAGE = "AllCategoryController";
    private static final String ALL_PRODUCT = "AllProduct";
    private static final String ALL_PRODUCT_PAGE = "AllProductController";
    private static final String SEARCH_PRODUCT_BY_NAME = "SearchProductByName";
    private static final String SEARCH_PRODUCT_BY_NAME_PAGE = "AllProductController";
    private static final String UPDATE_PRODUCT = "UpdateProduct";
    private static final String UPDATE_PRODUCT_PAGE = "UpdateProductController";
    private static final String UPDATE_INFORMATION_USER = "UpdateInformationUser";
    private static final String UPDATE_INFORMATION_USER_PAGE = "UpdateInformationUserController";
    private static final String UPDATE_INFORMATION_USER_PASSWORD = "UpdateUserPassword";
    private static final String UPDATE_INFORMATION_USER_PASSWORD_PAGE = "UpdateUserPasswordController";
    private static final String UPDATE_INFORMATION_EMPLOYEE = "UpdateEmployeeInformation";
    private static final String UPDATE_INFORMATION_EMPLOYEE_PAGE = "UpdateEmployeeInformationController";
    private static final String AUTHENTICATION_GOOGLE = "AuthenGoogle";
    private static final String AUTHENTICATION_GOOGLE_PAGE = "AuthenLoginGoogleController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (CREATE_CATEGORY.equals(action)) {
                url = CREATE_CATEGORY_PAGE;
            } else if (CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_PAGE;
            } else if (SIGNUP.equals(action)) {
                url = SIGNUP_PAGE;
            } else if (DETAIL_PRODUCT.equals(action)) {
                url = DETAIL_PRODUCT_PAGE;
            } else if (LOAD_SHOP.equals(action)) {
                url = LOAD_SHOP_PAGE;
            } else if (REMOVE_USER.equals(action)) {
                url = REMOVE_USER_PAGE;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_USER_PAGE;
            } else if (EMPLOYEE_UPDATE_USER.equals(action)) {
                url = EMPLOYEE_UPDATE_USER_PAGE;
            } else if (ADD_TO_CART.equals(action)) {
                url = ADD_TO_CART_PAGE;
            } else if (PROCESS_CART.equals(action)) {
                url = PROCESS_CART_PAGE;
            } else if (DETAIL_CART.equals(action)) {
                url = DETAIL_CART_PAGE;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_PAGE;
            } else if (DELIVERY_CHECKOUT.equals(action)) {
                url = DELIVERY_CHECKOUT_PAGE;
            } else if (DELIVERY_CHECKOUT_FORM.equals(action)) {
                request.setAttribute("MC", "MC");
                url = DELIVERY_CHECKOUT_FORM_PAGE;
            } else if (ALL_ORDERS.equals(action)) {
                url = ALL_ORDERS_PAGE;
            } else if (NEW_ORDERS.equals(action)) {
                url = NEW_ORDERS_PAGE;
            } else if (SEARCH_ORDER_BY_USERNAME_ORDERSID.equals(action)) {
                url = SEARCH_ORDER_BY_USERNAME_ORDERSID_PAGE;
            } else if (SET_STATUS_ORDER.equals(action)) {
                url = SET_STATUS_ORDER_PAGE;
            } else if (SEARCH_ORDER_BY_USERNAME_ORDERSID_STATUS_NEW.equals(action)) {
                url = SEARCH_ORDER_BY_USERNAME_ORDERSID_STATUS_NEW_PAGE;
            } else if (ORDER_DETAIL.equals(action)) {
                url = ORDER_DETAIL_PAGE;
            } else if (ALL_CATEGORY.equals(action)) {
                url = ALL_CATEGORY_PAGE;
            } else if (ALL_PRODUCT.equals(action)) {
                url = ALL_PRODUCT_PAGE;
            } else if (SEARCH_PRODUCT_BY_NAME.equals(action)) {
                url = SEARCH_PRODUCT_BY_NAME_PAGE;
            } else if (UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_PAGE;
            } else if (UPDATE_INFORMATION_USER.equals(action)) {
                url = UPDATE_INFORMATION_USER_PAGE;
            } else if (UPDATE_INFORMATION_USER_PASSWORD.equals(action)) {
                url = UPDATE_INFORMATION_USER_PASSWORD_PAGE;
            } else if (UPDATE_INFORMATION_EMPLOYEE.equals(action)) {
                url = UPDATE_INFORMATION_EMPLOYEE_PAGE;
            } else if (AUTHENTICATION_GOOGLE.equals(action)) {
                url = AUTHENTICATION_GOOGLE_PAGE;
            } else {
                request.setAttribute("ERROR", "Your action not support !");
            }
        } catch (Exception e) {
            System.out.println("Error at MainController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at MainController !");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
