/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import sample.dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.product.Category;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AllCategoryController", urlPatterns = {"/AllCategoryController"})
public class AllCategoryController extends HttpServlet {

    private static final String HOME = "UserManagementController";
    private static final String SUCCESS = "AllCategory.jsp";
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
        List<Category> listCate = new ArrayList<>();
        try {
            String keySearch = request.getParameter("keySearch");
            if (keySearch != null) {
                listCate = pDAO.GetCategoryByName(keySearch);
            } else {
                listCate = pDAO.GetAllCategory();
            }
            int indexPage = 1, start, end;
            int sizePaging = (listCate.size() % 5 == 0) ? (listCate.size() / 5) : (listCate.size() / 5 + 1);
            start = (indexPage - 1) * 5;
            end = indexPage * 5;
            String indexPage_raw = request.getParameter("page");
            if (indexPage_raw != null) {
                indexPage = Integer.parseInt(indexPage_raw);
            } else {
                indexPage = 1;
            }
            if (end >= listCate.size()) {
                end = listCate.size();
            }
            listCate=pDAO.PaginationCategory(listCate, start, end);
            request.setAttribute("sizePaging", sizePaging);
            request.setAttribute("listCate", listCate);
            request.setAttribute("page", indexPage);
            request.setAttribute("keySearch", keySearch);
            url = SUCCESS;

        } catch (Exception e) {
            System.out.println("Error at AllCategoryController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at AllCategoryController");
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
