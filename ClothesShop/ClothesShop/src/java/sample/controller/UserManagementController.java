/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "UserManagementController", urlPatterns = {"/UserManagementController"})
public class UserManagementController extends HttpServlet {

    private static final String SUCCESS = "UserManagement.jsp";
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
        String keySearch = request.getParameter("keySearch");
        List<User> listUser = new ArrayList<>();
        try {
            if (keySearch != null) {
                listUser = uDAO.SearchUserWithNameAndUserName(keySearch);
            } else {
                listUser = uDAO.GetUserWithStatusActiveWithStatus();
            }
            int start, end, indexPage = 1;
            String indexPage_raw = request.getParameter("page");
            if (indexPage_raw != null) {
                indexPage = Integer.parseInt(indexPage_raw);
            } else {
                indexPage = 1;
            }
            start = (indexPage - 1) * 5;
            end = indexPage * 5;
            if (end >= listUser.size()) {
                end = listUser.size();
            }
            int sizePaging = (listUser.size() % 5 == 0) ? (listUser.size() / 5) : (listUser.size() / 5 + 1);
            listUser = uDAO.PaginationUser(listUser, start, end);
            request.setAttribute("sizePaging", sizePaging);
            request.setAttribute("page", indexPage);
            request.setAttribute("keySearch", keySearch);
            request.setAttribute("listUser", listUser);
            url = SUCCESS;
        } catch (Exception e) {
            System.out.println("Error at UserManagementController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UserManagementController");
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
