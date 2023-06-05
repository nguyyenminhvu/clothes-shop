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
@WebServlet(name = "LoadPage", urlPatterns = {"/LoadPage"})
public class LoadIndexPage extends HttpServlet {

    private static final String SUCCESS = "index.jsp";
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
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getMapCart().isEmpty()) {
                    request.setAttribute("sizeCart", "0");
                } else {
                    request.setAttribute("sizeCart", cart.getMapCart().size());
                }
            } else {
                request.setAttribute("sizeCart", "0");
            }
            ProductDAO pDAO = new ProductDAO();
            List<Product> listProduct = pDAO.GetAllProduct();
            List<Product> listCheaper = pDAO.GetTop3Cheap();
            List<Product> listNew = pDAO.GetTop3New();
            List<Product> listBestSaller = pDAO.GetTop3BestSaler();
            int start, end, indexPage;
            if (listProduct != null && listCheaper != null && listNew != null && listBestSaller != null) {
                String indexPAge_raw = request.getParameter("page");
                if (indexPAge_raw != null) {
                    indexPage = Integer.parseInt(indexPAge_raw);
                } else {
                    indexPage = 1;
                }
                start = (indexPage - 1) * 8;
                end = indexPage * 8;
                if (end >= listProduct.size()) {
                    end = listProduct.size();
                }
                int sizePaging = (listProduct.size() % 8 == 0) ? (listProduct.size() / 8) : (listProduct.size() / 8 + 1);
                listProduct = pDAO.PaginationProduct(listProduct, start, end);
                request.setAttribute("listProduct", listProduct);
                request.setAttribute("listCheaper", listCheaper);
                request.setAttribute("listNew", listNew);
                request.setAttribute("listBestSaller", listBestSaller);
                request.setAttribute("page", indexPage);
                request.setAttribute("sizePaging", sizePaging);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Get list fail !! ");
            }
        } catch (Exception e) {
            System.out.println("Error at LoadPage with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at LoadPage!");
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
