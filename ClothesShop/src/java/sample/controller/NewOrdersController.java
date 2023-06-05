/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.orders.Order;

/**
 *
 * @author ACER
 */
@WebServlet(name = "NewOrdersController", urlPatterns = {"/NewOrdersController"})
public class NewOrdersController extends HttpServlet {

    private static final String HOME = "UserManagementController";
    private static final String SUCCESS = "NewOrders.jsp";
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
        ProductDAO pDAO = new ProductDAO();
        List<Order> listOrder = new ArrayList<>();
        try {
            String search = request.getParameter("keySearch");
            if (search != null) {
                listOrder = pDAO.SearchOrdersWithStatusNews(search);
                request.setAttribute("keySearch", search);
            } else {
                listOrder = pDAO.GetOrderWithStatusNew();
            }
            String indexPage_raw = request.getParameter("page");
            int indexPage = 1;
            if (indexPage_raw != null) {
                indexPage = Integer.parseInt(indexPage_raw);
            } else {
                indexPage = 1;
            }
            int start, end;
            start = (indexPage - 1) * 5;
            end = indexPage * 5;
            int sizePaging = (listOrder.size() % 5 == 0) ? (listOrder.size() / 5) : (listOrder.size() / 5 + 1);
            if (end >= listOrder.size()) {
                end = listOrder.size();
            }
            List<Order> listTemp = pDAO.PaginationOrder(listOrder, start, end);
            if (listTemp.isEmpty() && pDAO.SearchOrdersWithStatusNews(search).size()>0) {
                indexPage = 1;
                start = (indexPage - 1) * 5;
                end = indexPage * 5;
                listOrder = pDAO.GetOrderWithStatusNew();
                listOrder = pDAO.PaginationOrder(listOrder, start, end);
            } else {
                listOrder = listTemp;
            }
            request.setAttribute("page", indexPage);
            request.setAttribute("sizePaging", sizePaging);
            request.setAttribute("listOrders", listOrder);
            url = SUCCESS;
        } catch (Exception e) {
            System.out.println("Error at NewOrdersController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at NewOrdersController");
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
