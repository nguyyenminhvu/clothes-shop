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
import javax.servlet.http.HttpSession;
import sample.model.product.Cart;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
@WebServlet(name = "DetailProductController", urlPatterns = {"/DetailProductController"})
public class DetailProductController extends HttpServlet {

    private static final String SUCCESS = "ProductDetail.jsp";
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
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getMapCart().isEmpty()) {
                    request.setAttribute("sizeCart", "0");
                } else {
                    request.setAttribute("sizeCart", cart.getMapCart().size());
                }
            }else {
                request.setAttribute("sizeCart", "0");
            }
            String id_raw = request.getParameter("id");
            if (id_raw != null) {
                int id = Integer.parseInt(id_raw);
                List<Product> listProduct = pDAO.GetTop4BestSaler();
                Product p = pDAO.GetProductById(id);
                if (p != null) {
                    request.setAttribute("product", p);
                    request.setAttribute("top4", listProduct);
                    url = SUCCESS;
                }
            } else {
                url = "LoadPage";
            }
        } catch (Exception e) {
            System.out.println("Error at DetailProductController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at DetailProductController");
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
