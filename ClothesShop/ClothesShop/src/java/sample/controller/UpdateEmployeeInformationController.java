/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.user.Employee;
import sample.model.user.UpdateInformationERROR;
import sample.model.user.User;
import sample.model.user.UserERROR;

/**
 *
 * @author ACER
 */
@WebServlet(name = "UpdateEmployeeInformationController", urlPatterns = {"/UpdateEmployeeInformationController"})
public class UpdateEmployeeInformationController extends HttpServlet {

    private static final String HOME = "UserManagementController";
    private static final String SUCCESS = "EmployeeUpdateInformation.jsp";
    private static final String ERROR = "ErrorJSP.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmployeeInformationController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateEmployeeInformationController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String url = ERROR;
        UserDAO uDAO = new UserDAO();
        try {
            String username = request.getParameter("username");
            if (username != null) {
                Employee e = uDAO.GetEmployeeByUsername(username);
                if (e != null) {
                    request.setAttribute("e", e);
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Your action not support");
                }
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateEmployeeInformationController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateEmployeeInformationController");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
        String url = ERROR;
        UserDAO uDAO = new UserDAO();
        UserERROR uERROR = new UserERROR();
        try {
            Boolean check = true;
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String newPassword = request.getParameter("newpassword");
            String reNewPassword = request.getParameter("renewpassword");
            if (uDAO.CheckLoginEmployee(username, password) != null) {
                if (name.matches("^[a-zA-Z0-9 ]*$")) {
                    if (name.trim().length() == 0) {
                        uERROR.setFullNameError("Type your name please");
                        check = false;
                    }
                } else {
                    uERROR.setFullNameError("No special char please");
                    check = false;
                }
                if (newPassword.length() < 5 || newPassword.length() > 15) {
                    if (!newPassword.equals(reNewPassword)) {
                        uERROR.setRePasswordError("Two password not equal");
                        check = false;
                    }
                } else {
                    uERROR.setNewPasswordError("Length password must be [5-15]");
                    check = false;
                }
                if (check) {
                    if (uDAO.UpdateEmployeeInformation(username, newPassword, name)) {
                        url = "UserManagementController";
                        request.setAttribute("uriBack", "UserManagementController");
                        request.setAttribute("msg", "Update successful");
                    } else {
                        uERROR.setPasswordError("Can't update your information, call police please");
                        url = SUCCESS;
                    }
                } else {
                    url = SUCCESS;
                    request.setAttribute("updateError", uERROR);
                }
            } else {
                uERROR.setPasswordError("Wrong password sir");
                request.setAttribute("updateError", uERROR);
                url = SUCCESS;
            }
            if (url.equals(SUCCESS)) {
                Employee e = new Employee(username, password, " ", name);
                request.setAttribute("e", e);
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateEmployeeInformationController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateEmployeeInformationController method POST");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
