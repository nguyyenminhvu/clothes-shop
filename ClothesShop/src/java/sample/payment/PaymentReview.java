/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.model.product.Cart;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
@WebServlet(name = "PaymentReview", urlPatterns = {"/PaymentReview"})
public class PaymentReview extends HttpServlet {

    private static final String HOME = "LoadPage";
    private static final String ERROR = "ErrorJSP.jsp";
    private static final String SUCCESS = "ReviewPayment.jsp";
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
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                double total = 0;
                for (Product value : cart.getMapCart().values()) {
                    total += value.getQuantity() * value.getPrice();
                }
                total += cart.getMapCart().size() * TAX + cart.getMapCart().size() * SHIPPING;

                PaymentService paymentService = new PaymentService();

                Payment payment = paymentService.getPaymentDetails(paymentId);

                PayerInfo payerInfo = payment.getPayer().getPayerInfo();

                Transaction transaction = payment.getTransactions().get(0);

                ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

                request.setAttribute("payer", payerInfo);
                request.setAttribute("transaction", transaction);
                request.setAttribute("shippingAddress", shippingAddress);
                request.setAttribute("totalResult", total);
                url = SUCCESS + "?paymentId=" + paymentId + "&PayerID=" + payerId;
            } else {
                url = HOME;
            }
        } catch (PayPalRESTException e) {
            System.out.println("Error at PaymentReview with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentReview with PayPalRESTException");
        } catch (Exception e) {
            System.out.println("Error at PaymentReview with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentReview with problem CART");
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
