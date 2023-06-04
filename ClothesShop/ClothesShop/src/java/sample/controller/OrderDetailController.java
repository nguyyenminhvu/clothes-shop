/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.orders.OrderDetail;

/**
 *
 * @author ACER
 */
@WebServlet(name = "OrderDetailController", urlPatterns = {"/OrderDetailController"})
public class OrderDetailController extends HttpServlet {
    
    private static final String HOME = "UserManagementController";
    private static final String SUCCESS = "OrdersDetail.jsp";
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
        try {
            int orderid = Integer.parseInt(request.getParameter("orderid"));
            List<OrderDetail> listOderDetail = pDAO.GetOrderDetailByOrderId(orderid);
            if (listOderDetail != null) {
                double tax = listOderDetail.size() * 5;
                double shipping = listOderDetail.size() * 10;
                double subTotal = 0;
                for (OrderDetail orderDetail : listOderDetail) {
                    subTotal += orderDetail.getPrice() * orderDetail.getQuantity();
                }
                double total = subTotal + tax + shipping;
                request.setAttribute("orderid", request.getParameter("orderid"));
                request.setAttribute("username", request.getParameter("username"));
                request.setAttribute("uriBack", request.getParameter("uriBack"));
                request.setAttribute("status", request.getParameter("status"));
                request.setAttribute("tax", tax);
                request.setAttribute("shipping", shipping);
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("total", total);
                request.setAttribute("listOrderDetail", listOderDetail);
                url = SUCCESS;
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at OrderDetailController with ERROR:　" + e.toString());
            request.setAttribute("ERROR", "Error at OrderDetailController");
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
