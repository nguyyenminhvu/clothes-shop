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
import javax.servlet.http.HttpSession;
import sample.model.orders.OrderDetail;
import sample.model.payment.DeliveryBill;
import sample.model.payment.DeliveryShipping;
import sample.model.product.Cart;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "DeliveryCheckoutController", urlPatterns = {"/DeliveryCheckoutController"})
public class DeliveryCheckoutController extends HttpServlet {

    private static final String SUCCESS = "ReceiptDelivery.jsp";
    private static final String ERROR = "ErrorJSP.jsp";
    private static final String HOME = "LoadPage";
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
            HttpSession session = request.getSession();
            UserDAO uDAO = new UserDAO();
            Cart cart = (Cart) session.getAttribute("CART");
            User userAcc = (User) session.getAttribute("ACC");
            ProductDAO pDAO = new ProductDAO();
            if (userAcc != null && cart != null) {
                User user = uDAO.GetUserByUsername(userAcc.getUsername());
                if (user != null) {
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String address = request.getParameter("address");
                    double subTotal = cart.GetTotal();
                    double total = TAX * cart.getMapCart().size() + SHIPPING * cart.getMapCart().size() + subTotal;
                    DeliveryShipping deliveryShipping = new DeliveryShipping(firstName, lastName, email, phone, address);
                    DeliveryBill bill = new DeliveryBill(subTotal, TAX, SHIPPING, total, deliveryShipping);
                    if (pDAO.InsertOrder(cart, user, deliveryShipping)) {
                        request.setAttribute("bill", bill);
                        url = SUCCESS;
                        session.removeAttribute("CART");
                    } else {
                        request.setAttribute("ERROR", "Insert order failed");
                    }
                } else {
                    request.setAttribute("ERROR", "You are hacker, i called 911");
                }
            } else {
                url = HOME;
            }
        } catch (Exception e) {
            System.out.println("Error at DeliveryCheckoutController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at DeliveryCheckoutController");
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
