/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.ProductDAO;
import sample.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.user.UpdateInformationERROR;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "UpdateInformationUserController", urlPatterns = {"/UpdateInformationUserController"})
public class UpdateInformationUserController extends HttpServlet {

    private static final String HOME = "LoadPage";
    private static final String SUCCESS = "UserUpdateInformation.jsp";
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
            out.println("<title>Servlet UpdateInformationUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateInformationUserController at " + request.getContextPath() + "</h1>");
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
                User u = uDAO.GetUserByUsername(username);
                if (u != null) {
                    request.setAttribute("u", u);
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Your action not support");
                }
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateInformationUserController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateInformationUserController");
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
        UpdateInformationERROR uERROR = new UpdateInformationERROR();
        try {
            Boolean check = true;
            String username = request.getParameter("username");
            String phone = request.getParameter("phone");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            if (uDAO.CheckLoginUser(username, password) != null) {
                if (name.matches("^[a-zA-Z0-9 ]*$")) {
                    if (name.trim().length() == 0) {
                        uERROR.setNameError("Type your name please");
                        check = false;
                    }
                } else {
                    uERROR.setNameError("No special char please");
                    check = false;
                }
                if (phone.matches("^[a-zA-Z0-9 ]*$")) {
                    if (phone.trim().length() == 0) {
                        uERROR.setPhoneError("Type your phone please");
                        check = false;
                    }
                } else {
                    uERROR.setPhoneError("No special char please");
                    check = false;
                }
                if (address.matches("^[a-zA-Z0-9 ]*$")) {
                    if (address.trim().length() == 0) {
                        uERROR.setAddressError("Type your address please");
                        check = false;
                    }
                } else {
                    uERROR.setAddressError("No special char please");
                    check = false;
                }
                if (check) {
                    if (uDAO.UpdateUser(name, phone, address, username)) {
                        url = "LoadInformationUserController";
                        request.setAttribute("uriBack", request.getParameter("uriBack"));
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
                User u = new User(username, password, " ", name, phone, address, true);
                request.setAttribute("u", u);
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateInformationUserController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateInformationUserController method POST");
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
