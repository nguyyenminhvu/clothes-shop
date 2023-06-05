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

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoadInformationUserController", urlPatterns = {"/LoadInformationUserController"})
public class LoadInformationUserController extends HttpServlet {

    private static final String HOME = "LoadPage";
    private static final String SUCCESS = "ShowInformationUser.jsp";
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
        String url = ERROR;
        UserDAO uDAO = new UserDAO();
        try {
            String username = request.getParameter("username");
            if (username != null) {
                User u = uDAO.GetUserByUsername(username);
                if (u != null) {
                    request.setAttribute("u", u);
                    request.setAttribute("msg", request.getAttribute("msg"));
                    request.setAttribute("uriBack", "LoadPage");
                    if (request.getParameter("key").equals("UpdatePassword")) {
                        url = "UserUpdatePassword.jsp";
                    } else {
                        url = SUCCESS;
                    }
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
