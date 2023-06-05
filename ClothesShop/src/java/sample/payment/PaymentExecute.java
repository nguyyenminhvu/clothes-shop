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
import sample.dao.ProductDAO;
import sample.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.model.payment.DeliveryShipping;
import sample.model.product.Cart;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "PaymentExecute", urlPatterns = {"/PaymentExecute"})
public class PaymentExecute extends HttpServlet {

    private static final String ERROR = "ErrorJSP.jsp";
    private static final String SUCCESS = "ReceiptPayal.jsp";
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
        String url = ERROR;
        try {
            String payerId = request.getParameter("PayerID");
            String paymentId = request.getParameter("paymentId");
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            ProductDAO pDAO = new ProductDAO();
            UserDAO uDAO = new UserDAO();
            User user = (User) session.getAttribute("ACC");
            PaymentService paymentServices = new PaymentService();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
            String firstName = payerInfo.getFirstName();
            String lastName = payerInfo.getLastName();
            String email = payerInfo.getEmail();
            String phone = shippingAddress.getPhone();
            String address = shippingAddress.getCity();
            DeliveryShipping deliveryShipping = new DeliveryShipping(firstName, lastName, email, phone, address);
            Boolean haha = true;
            if (cart != null && user != null) {
                if (pDAO.InsertOrder(cart, user, deliveryShipping)) {
                    request.setAttribute("payer", payerInfo);
                    request.setAttribute("transaction", transaction);
                    session.removeAttribute("CART");
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Can't save order");
                }
            } else {
                url = HOME;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error at PaymentExecute with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentExecute");
        } catch (PayPalRESTException e) {
            System.out.println("Error at PaymentExecute with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at PaymentExecute paypal error.");
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
