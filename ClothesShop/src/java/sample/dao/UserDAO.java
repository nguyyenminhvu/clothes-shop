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
import java.util.List;
import sample.model.user.Employee;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
public class UserDAO {

    //sua lai role, check lai class nay
//WHERE a.username=? AND a.password=?
    private static final String AUTHENTICATIONS_EMPLOYEE = "SELECT a.username, a.password, a.role, e.name,  e.status FROM Authorizations AS a INNER JOIN Employee AS e ON a.username=e.username WHERE a.username=? and a.password=?";
    private static final String AUTHENTICATIONS = "SELECT a.username, a.password, a.role, u.name, u.phone, u.address, u.status FROM Authorizations AS a INNER JOIN Users AS u ON a.username=u.username WHERE a.username= ? AND a.password=?";
    private static final String CHECK_EXIST_USER = "SELECT * FROM Authorizations WHERE Username=?";
    private static final String INSERT_USER_AUTHORIZATION = "INSERT INTO Authorizations (username,password,role,dateCreate) VALUES (?,?,?,GETDATE())";
    private static final String INSERT_USER = "INSERT INTO Users(username,name,phone,address,status) VALUES (?,?,?,?,?)";
    private static final String GET_ALL_USER = "SELECT  a.username, u.name, u.phone, u.address, u.status FROM Authorizations AS a JOIN Users AS u ON a.username = u.username";
    private static final String SET_INACTIVE = "UPDATE Users SET status=0 WHERE username=?";
    private static final String SET_ACTIVE = "UPDATE Users SET status=1 WHERE username=?";
    private static final String SEARCH_USER = "SELECT a.username, a.password, a.role, u.name, u.phone, u.address, u.status FROM Authorizations AS a INNER  JOIN Users AS u ON a.username=u.username WHERE u.name LIKE ? or  u.username LIKE ?";
    private static final String GET_USER_BY_USERNAME = "SELECT a.username, a.password, a.role, u.name, u.phone, u.address, u.status FROM Authorizations AS a INNER  JOIN Users AS u ON a.username=u.username WHERE a.username= ? ";
    private static final String UPDATE_USER = "UPDATE Users SET name=?, phone=?, address=? WHERE username=?";
    private static final String UPDATE_USER_PASSWORD = "UPDATE Authorizations SET password=? WHERE username=?";
    private static final String GET_EMPLOYEE_BY_USERNAME = "SELECT a.username, password, role, name, status FROM Authorizations AS a INNER  JOIN Employee AS e ON a.username=e.username WHERE a.username= ? ";
    private static final String UPDATE_EMPLOYEE_INFORMATION = "UPDATE Authorizations SET password=? WHERE username=?";

    public UserDAO() {
    }

    public User CheckLoginUser(String username, String password) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(AUTHENTICATIONS);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("status")) {
                    User user = new User(username, "********", rs.getString("role"), rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at CheckLogin with ERROR: " + e.toString());
        }
        return null;
    }

    public Employee CheckLoginEmployee(String username, String password) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(AUTHENTICATIONS_EMPLOYEE);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(username, "********", rs.getString("role"), rs.getString("name"), rs.getBoolean("status"));
                return employee;
            }
        } catch (SQLException e) {
            System.out.println("Error at CheckLoginEmployee with ERROR: " + e.toString());
        }
        return null;
    }

    public Boolean CheckUserExist(String username) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(CHECK_EXIST_USER);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error at CheckUserExist with ERROR: " + e.toString());
        }
        return false;
    }

    public Boolean InsertUser(User user) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_USER_AUTHORIZATION);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRole());
            if (st.executeUpdate() > 0) {
                if (InsertUserV2(user)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at InsertUser with ERROR: " + e.toString());
        }
        return false;
    }

    private Boolean InsertUserV2(User user) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(INSERT_USER);
            st.setString(1, user.getUsername());
            st.setString(2, user.getName());
            st.setString(3, user.getPhone());
            st.setString(4, user.getAddress());
            st.setBoolean(5, user.isStatus());
            Boolean check = st.executeUpdate() > 0;
            return check;
        } catch (SQLException e) {
            System.out.println("Error at InsertUserV2 with ERROR: " + e.toString());
        }
        return false;
    }

    public List<User> GetUserWithStatusActive() throws ClassNotFoundException {
        List<User> listUser = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_USER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("status")) {
                    User user = new User(rs.getString("username"), "********", "USER", rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                    listUser.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at GetUserWithStatusActive with ERROR: " + e.toString());
        }
        return listUser;
    }

    public List<User> GetUserWithStatusActiveWithStatus() throws ClassNotFoundException {
        List<User> listUser = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_ALL_USER);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("username"), "********", "USER", rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error at GetUserWithStatusActive with ERROR: " + e.toString());
        }
        return listUser;
    }

    public Boolean ChangeStatusUser(String username, boolean status) {
        PreparedStatement st = null;
        try {
            if (status) {
                st = DBUtils.getConnection().prepareStatement(SET_INACTIVE);
            } else {
                st = DBUtils.getConnection().prepareStatement(SET_ACTIVE);
            }
            st.setString(1, username);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error at ChangeStatusUser with ERROR: " + e.toString());
        }
        return false;
    }

    public List<User> SearchUserWithNameAndUserName(String name) throws ClassNotFoundException {
        List<User> listUser = new ArrayList<>();
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(SEARCH_USER);
            st.setString(1, "%" + name + "%");
            st.setString(2, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("username"), "********", "USER", rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchUserWithName with ERROR: " + e.toString());
        }
        return listUser;
    }

    public User GetUserByUsername(String username) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_USER_BY_USERNAME);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("status")) {
                    User user = new User(rs.getString("username"), "********", "USER", rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erorr at GetUserByUsername with ERROR: " + e.toString());
        }
        return null;
    }

    public User GetUserByUsernameWithStatus(String username) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_USER_BY_USERNAME);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), "********", "USER", rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getBoolean("status"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Erorr at GetUserByUsername with ERROR: " + e.toString());
        }
        return null;
    }

    public List<User> PaginationUser(List<User> listUser, int start, int end) {
        List<User> listUserNew = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listUserNew.add(listUser.get(i));
        }
        return listUserNew;
    }

    public Boolean UpdateUser(String name, String phone, String address, String username) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(UPDATE_USER);
            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, address);
            st.setString(4, username);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at UpdateUser with ERROR: " + e.toString());
        }
        return false;
    }

    public Boolean UpdateUserPassword(String username, String password) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(UPDATE_USER_PASSWORD);
            st.setString(1, password);
            st.setString(2, username);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error at UpdateUserPassword with ERROR: " + e.toString());
        }
        return false;
    }

    public Employee GetEmployeeByUsername(String username) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(GET_EMPLOYEE_BY_USERNAME);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("name"), rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            System.out.println("Error at GetEmployeeByUsername with ERROR: " + e.toString());
        }
        return null;
    }

    public Boolean UpdateEmployeeInformation(String username, String password, String fullname) throws ClassNotFoundException {
        try {
            PreparedStatement st = DBUtils.getConnection().prepareStatement(UPDATE_EMPLOYEE_INFORMATION);
            st.setString(1, password);
            st.setString(2, username);
            if (st.executeUpdate() > 0) {
                if (fullname != null) {
                    PreparedStatement st01 = DBUtils.getConnection().prepareStatement("UPDATE Employee SET name=? WHERE username=?");
                    st01.setString(1, fullname);
                    st01.setString(2, username);
                    return st01.executeUpdate() > 0;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error ar UpdateEmployeeInformation with ERROR: " + e.toString());
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        UserDAO u = new UserDAO();
//        User user = new User("anhiuem", "anhiuem", "USER", "Nguyen Van Dijk");
//        System.out.println(u.UpdateEmployeeInformation("admin", "1","Zan Dai"));
        System.out.println(u.CheckLoginUser("nguyen", "1"));
    }
}
