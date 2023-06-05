/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.model.payment.OrderPayment;
import sample.model.product.Cart;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
@WebServlet(name = "PaymentConvert", urlPatterns = {"/PaymentConvert"})
public class PaymentConvert extends HttpServlet {

    private static final String HOME = "LoadPage";
    private static final String SUCCESS = "PaymentAuthor";
    private static final String ERROR = "ErrorJSP.jsp";
    private static final double TAX = 5.0;
    private static final double SHIPPING = 10.0;

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
            List<OrderPayment> listOrderPayment = new ArrayList<>();
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                for (Product p : cart.getMapCart().values()) {
                    OrderPayment o = new OrderPayment(p.getName(), String.format("%.2f", p.getPrice()), p.getQuantity(), String.format("%.2f", TAX), String.format("%.2f", SHIPPING));
                    listOrderPayment.add(o);
                }
                request.setAttribute("listOrderPayment", listOrderPayment);
                request.setAttribute("key", "PaymentConvert");
                url = SUCCESS;
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at PaymentConvert with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentConvert");
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
