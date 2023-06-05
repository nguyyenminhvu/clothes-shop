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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.model.product.Cart;
import sample.model.product.Category;
import sample.model.product.Product;

/**
 *
 * @author ACER
 */
@WebServlet( name = "LoadShopController", urlPatterns = {"/LoadShopController"},loadOnStartup = 1)
public class LoadShopController extends HttpServlet {

    private static final String SUCCESS = "Shop.jsp";
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
        List<Product> listProduct = new ArrayList<>();
        int indexPage;
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
            String idCate = request.getParameter("idCate");
            String priceNum_raw = request.getParameter("priceNum");
            String keyword = request.getParameter("keyword");
            String keySearch = request.getParameter("keySearch");
            String sortNum_raw = request.getParameter("sortNum");
            if (idCate != null && idCate.length() > 0) {
                if (Integer.parseInt(idCate) > 0) {
                    listProduct = pDAO.GetProductByCategoryId(Integer.parseInt(idCate));
                    request.setAttribute("nameShow", pDAO.GetCategoryById(Integer.parseInt(idCate)).getName());
                    request.setAttribute("idCate", idCate);
                } else {
                    listProduct = pDAO.GetAllProduct();
                    request.setAttribute("nameShow", "All");
                    request.setAttribute("idCate", "-1");
                }
            } else if (priceNum_raw != null && !priceNum_raw.isEmpty()) {
                int priceNum = Integer.parseInt(priceNum_raw);
                double froms = 0, tos = 0;
                if (priceNum > 0) {
                    switch (priceNum) {
                        case 1 -> {
                            froms = 0;
                            tos = 100;
                        }
                        case 2 -> {
                            froms = 100;
                            tos = 200;
                        }
                        case 3 -> {
                            froms = 200;
                            tos = 250;
                        }
                        case 4 -> {
                            froms = 250;
                            tos = 400;
                        }
                        case 5 -> {
                            froms = 400;
                            tos = 450;
                        }
                        case 6 -> {
                            froms = 450;
                            tos = -1;
                        }
                    }
                    listProduct = pDAO.GetProductByPrice(froms, tos);
                    if (tos > 0) {
                        request.setAttribute("nameShow", "Price from $ " + froms + " to $ " + tos);
                        request.setAttribute("priceNum", priceNum);
                    } else {
                        request.setAttribute("nameShow", "Price from $ " + froms + "+ ");
                        request.setAttribute("priceNum", priceNum);
                    }
                } else {
                    listProduct = pDAO.GetAllProduct();
                    request.setAttribute("nameShow", "All");
                    request.setAttribute("priceNum", "-1");
                }
            } else if (keyword != null && keyword.length() > 0) {
                listProduct = pDAO.SearchProductByKeyWord(keyword);
                request.setAttribute("nameShow", "#keyword: " + keyword);
            } else if (keySearch != null) {
                listProduct = pDAO.SearchProductByKeyWord(keySearch);
                request.setAttribute("rsSearch", keySearch);
                request.setAttribute("nameShow", "Search '" + keySearch + "' result:");
            } else {
                listProduct = pDAO.GetAllProduct();
                request.setAttribute("nameShow", "All");
                request.setAttribute("idCate", "-1");
            }
            int sizeProduct = 6;
            String indexPage_raw = request.getParameter("page");
            if (indexPage_raw != null) {
                indexPage = Integer.parseInt(indexPage_raw);
            } else {
                indexPage = 1;
            }
            int start = (indexPage - 1) * sizeProduct;
            int end = indexPage * sizeProduct;
            if (end > listProduct.size()) {
                end = listProduct.size();
            }
            int sizePaging = (listProduct.size() % 6 == 0) ? listProduct.size() / 6 : listProduct.size() / 6 + 1;
            listProduct = pDAO.PaginationProduct(listProduct, start, end);
            if (sortNum_raw != null && !sortNum_raw.isEmpty()) {
                int sortNum = Integer.parseInt(sortNum_raw);
                if (sortNum == 1) {
                    Collections.sort(listProduct, (p1, p2) -> {
                        int i = 0;
                        if (p1.getPrice() < p2.getPrice()) {
                            i = -1;
                        }
                        if (p1.getPrice() > p2.getPrice()) {
                            i = 1;
                        }
                        if (p1.getPrice() == p2.getPrice()) {
                            return p1.getName().compareTo(p2.getName());
                        }
                        return i;
                    });
                } else if (sortNum == 2) {
                    Collections.sort(listProduct, (p1, p2) -> {
                        int i = 0;
                        if (p1.getPrice() < p2.getPrice()) {
                            i = 1;
                        }
                        if (p1.getPrice() > p2.getPrice()) {
                            i = -1;
                        }
                        if (p1.getPrice() == p2.getPrice()) {
                            return p1.getName().compareTo(p2.getName());
                        }
                        return i;
                    });
                }
            }
            List<Category> listCategory = pDAO.GetAllCategory();
            request.setAttribute("sizePaging", sizePaging);
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listCate", listCategory);
            request.setAttribute("page", indexPage);
            url = SUCCESS;
        } catch (Exception e) {
            System.out.println("Error at LoadShopController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at LoadShopController ");
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
