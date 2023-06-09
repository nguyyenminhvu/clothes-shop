/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.payment.OrderPayment;



/**
 *
 * @author ACER
 */
@WebServlet(name = "PaymentAuthor", urlPatterns = {"/PaymentAuthor"})
public class PaymentAuthor extends HttpServlet {
    private static final String HOME="LoadPage";
    private static final String ERROR = "ErrorJSP.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<OrderPayment> orderPaymentList = (List<OrderPayment>) request.getAttribute("listOrderPayment");
        String key = (String) request.getAttribute("key");
        try {
            if (key != null) {
                PaymentService paymentServices = new PaymentService();
                String approvalLink = paymentServices.authorizePayment(orderPaymentList);
                response.sendRedirect(approvalLink);
            } else {
                request.setAttribute("ERROR", "Sorry! Your action not support");
                request.getRequestDispatcher(HOME).forward(request, response);
            }
        } catch (PayPalRESTException e) {
            System.out.println("Error at AuthorizePaymentServlet with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentAuthor with ERROR: "+e.toString());
            request.getRequestDispatcher(ERROR).forward(request, response);
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
