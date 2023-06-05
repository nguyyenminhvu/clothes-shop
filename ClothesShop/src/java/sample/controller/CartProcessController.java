/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CartProcessController", urlPatterns = {"/CartProcessController"})
public class CartProcessController extends HttpServlet {

    private static final String SUCCESS = "Cart.jsp";
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
            out.println("<title>Servlet CartProcessController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartProcessController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ProductDAO pDAO = new ProductDAO();
        try {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null && cart.getMapCart().size() > 0) {
                Product p = pDAO.GetProductById(id);
                p.setQuantity(quantity);
                cart.AddToCart(p);
                session.setAttribute("CART", cart);
                request.setAttribute("total", cart.GetTotal());
                request.setAttribute("sizeCart", cart.getMapCart().size());
                url = SUCCESS;
            } else {
                url = "LoadPage";
            }
        } catch (Exception e) {
            System.out.println("Error at CartProcessController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at CartProcessController method GET");
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
        HttpSession session = request.getSession();
        ProductDAO pDAO = new ProductDAO();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null && cart.getMapCart().size() > 0) {
                cart.RemoveProduct(id);
                request.setAttribute("total", cart.GetTotal());
                request.setAttribute("sizeCart", cart.getMapCart().size());
                url = SUCCESS;
            } else {
                url = "LoadPage";
            }
        } catch (Exception e) {
            System.out.println("Error at CartProcessController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at CartProcessController method POST");
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
