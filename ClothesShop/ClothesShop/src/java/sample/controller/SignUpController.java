/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.user.User;
import sample.model.user.UserERROR;

/**
 *
 * @author ACER
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    private static final String SUCCESS = "Login.html";
    private static final String ERROR = "SignUp.jsp";
    private static final String ERROR_PAGE = "ErrorJSP.jsp";

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
        UserERROR eRROR = new UserERROR();
        try {
            UserDAO uDAO = new UserDAO();
            boolean check = true;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String fullname = request.getParameter("fullname");
            String role = request.getParameter("role");
            if (username.matches("[a-zA-Z0-9]+")) {
                if (!uDAO.CheckUserExist(username)) {
                    if (username.length() < 5 || username.length() > 15) {
                        eRROR.setUsernameError("Username must be [5-15]");
                        check = false;
                    }
                    if (password.length() < 5 || password.length() > 15) {
                        eRROR.setPasswordError("Password must be [5-15]");
                        check = false;
                    } else {
                        if (!password.equals(repassword)) {
                            eRROR.setRePasswordError("Two password not equal !");
                            check = false;
                        }
                    }
                    if (fullname.length() < 3 || fullname.length() > 15) {
                        eRROR.setFullNameError("Fullname must be [5-15] !");
                    }
                    if (check) {
                        User u = new User(username, password, role, fullname);
                        if (uDAO.InsertUser(u)) {
                            url = SUCCESS;
                        } else {
                            url = ERROR;
                            request.setAttribute("ERROR", "Insert user fail !!");
                        }
                    } else {
                        request.setAttribute("USER_ERROR", eRROR);
                    }
                } else {
                    eRROR.setUsernameError("Username already exist !!");
                    request.setAttribute("USER_ERROR", eRROR);
                }
            } else {
                eRROR.setUsernameError("Do not use special char");
                request.setAttribute("USER_ERROR", eRROR);
            }
        } catch (Exception e) {
            System.out.println("Error at SignUpController with ERROR: " + e.toString());
            url = ERROR_PAGE;
            request.setAttribute("ERROR", "Error at SignUpController !!");
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
