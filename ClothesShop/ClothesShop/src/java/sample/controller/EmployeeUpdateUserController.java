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
import sample.model.user.User;
import sample.model.user.UserERROR;
import sample.model.user.UserUpdatepERROR;

/**
 *
 * @author ACER
 */
@WebServlet(name = "EmployeeUpdateUserController", urlPatterns = {"/EmployeeUpdateUserController"})
public class EmployeeUpdateUserController extends HttpServlet {

    private static final String SUCCESS = "UserManagementController";
    private static final String ERROR = "ErrorJSP.jsp";
    private static final String HOME = "LoadPage";

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
            out.println("<title>Servlet EmployeeUpdateUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeUpdateUserController at " + request.getContextPath() + "</h1>");
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
        try {
            String username = request.getParameter("username");
            UserDAO uDAO = new UserDAO();
            if (username != null) {
                User u = uDAO.GetUserByUsernameWithStatus(username);
                if (u != null) {
                    request.setAttribute("USER", u);
                    url = "EmployeeUpdateUser.jsp";
                } else {
                    request.setAttribute("ERROR", "Error at EmployeeUpdateUserController, can't get Account from DB ");
                }
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at EmployeeUpdateUserController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at EmployeeUpdateUserController");
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
        UserUpdatepERROR uERROR = new UserUpdatepERROR();
        try {
            boolean check = true;
            String username = request.getParameter("username");
            User u = uDAO.GetUserByUsername(username);
            String name = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            if (name.matches("^[a-zA-Z0-9 ]*$")) {
                if (name.trim().length() == 0) {
                    uERROR.setFullNameERROR("Type your name please");
                    check = false;
                }
            } else {
                uERROR.setFullNameERROR("No special char please");
                check = false;
            }
            if (phone.matches("^[a-zA-Z0-9 ]*$")) {
                if (phone.trim().length() == 0) {
                    uERROR.setPhoneERROR("Type your phone please");
                    check = false;
                }
            } else {
                uERROR.setPhoneERROR("No special char please");
                check = false;
            }
            if (address.matches("^[a-zA-Z0-9 ]*$")) {
                if (address.trim().length() == 0) {
                    uERROR.setAddressERROR("Type your address please");
                    check = false;
                }
            } else {
                uERROR.setAddressERROR("No special char please");
                check = false;
            }
            if (check) {
                if (uDAO.UpdateUser(name, phone, address, username)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update fail at EmployeeUpdateUserController method POST");
                }
            } else {
                url = "EmployeeUpdateUser.jsp";
                request.setAttribute("USER", u);
                request.setAttribute("uERROR", uERROR);
            }
        } catch (Exception e) {
            System.out.println("Error at EmployeeUpdateUserController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at EmployeeUpdateUserController");
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
