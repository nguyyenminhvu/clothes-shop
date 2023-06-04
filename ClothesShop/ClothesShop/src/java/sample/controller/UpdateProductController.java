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
import sample.model.product.Category;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

    private static final String HOME = "UserManagementController";
    private static final String SUCCESS = "UpdateProduct.jsp";
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
            out.println("<title>Servlet UpdateProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductController at " + request.getContextPath() + "</h1>");
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
        ProductDAO pDAO = new ProductDAO();
        try {
            List<Category> listCategory = pDAO.GetAllCategory();
            int id = Integer.parseInt(request.getParameter("id"));
            Product p = pDAO.GetProductByIdWithStatus(id);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("product", p);
            url = SUCCESS;
        } catch (Exception e) {
            System.out.println("Error at UpdateProductController with  ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateProductController");
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
        ProductDAO pDAO = new ProductDAO();
        try {
            
            String name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("id"));
            int idCate = Integer.parseInt(request.getParameter("idcate"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String img = request.getParameter("img");
            String isactive_raw = request.getParameter("isactive");
            Boolean isactive = (isactive_raw != null);
            Category category = pDAO.GetCategoryById(idCate);
            Product p = new Product(id, name, price, quantity, description, img, category, 0, isactive);
            if (pDAO.UpdateProduct(p)) {
                url = "AllProductController";
            } else {
                request.setAttribute("ERROR", "Failed update product");
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateProductController with  ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at UpdateProductController");
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
