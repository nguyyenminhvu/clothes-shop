/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.UserDAO;
import sample.model.google.AccountGoogleDTO;
import sample.model.google.AccountGoogleError;
import sample.model.user.User;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AuthenLoginGoogleController", urlPatterns = {"/AuthenLoginGoogleController"})
public class AuthenLoginGoogleController extends HttpServlet {
    
    private static final String ALREADY = "LoadPage";
    private static final String NOT_YET = "ConfirmPasswordGoogle.jsp";
    private static final String ERROR_LOGIN = "Login.html";
    private static final String ERROR_PAGE = "ErrorJSP.jsp";

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
            out.println("<title>Servlet AuthenLoginGoogleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthenLoginGoogleController at " + request.getContextPath() + "</h1>");
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
        String url = ERROR_LOGIN;
        try {
            UserDAO uDAO = new UserDAO();
            HttpSession session = request.getSession();
            String name = (String) request.getAttribute("nameGoogle");
            String email = (String) request.getAttribute("emailGoogle");
            String username = email.substring(0, email.lastIndexOf("@"));
            if (uDAO.CheckUserExistEmailMark(email)) {
                User user = uDAO.GetUserByUsername(username);
                url = ALREADY;
                session.setAttribute("ACC", user);
            } else {
                url = NOT_YET;
                request.setAttribute("nameGoogle", name);
                request.setAttribute("username", username);
                request.setAttribute("action", "CreateAccount");
            }
        } catch (Exception e) {
            System.out.println("Error at AuthenLoginGoogleController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at AuthenLoginGoogleController");
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
        String url = ERROR_PAGE;
        try {
            AccountGoogleError accountGoogleError = new AccountGoogleError();
            String nameGoogle = request.getParameter("nameGoogle");
            String username = request.getParameter("username");
            String email = username + "@gmail.com";
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            HttpSession session = request.getSession();
            boolean check = true;
            if (password.length() < 5 || password.length() > 15) {
                check = false;
                accountGoogleError.setPasswordError("Password must be [5-15] charater");
                url = NOT_YET;
                request.setAttribute("username", username);
                request.setAttribute("nameGoogle", nameGoogle);
                request.setAttribute("action", "CreateAccount");
            }
            if (!password.equals(repassword)) {
                check = false;
                accountGoogleError.setRePasswordError("Two password not equal");
                url = NOT_YET;
                request.setAttribute("username", username);
                request.setAttribute("nameGoogle", nameGoogle);
                request.setAttribute("action", "CreateAccount");
            }
            if (check) {
                UserDAO uDAO = new UserDAO();
                boolean checkInsert = uDAO.CheckUserExist(username);
                while (checkInsert) {
                    String code = "0123456789";
                    String rs = "";
                    int begin = (int) (code.length() * Math.random());
                    int end = 0;
                    if (begin == code.length() - 1) {
                        end = begin - 1;
                    } else {
                        end = begin + 1;
                    }
                    rs = code.substring(begin, end);
                    username += rs;
                    checkInsert = uDAO.CheckUserExist(username);
                }
                User user = new User(username, password, "USER", nameGoogle);
                if (uDAO.InsertUser(user)) {
                    if (uDAO.InsertEmailMark(username, email)) {
                        url = ALREADY;
                        response.sendRedirect(url);
                        session.setAttribute("ACC", user);
                    }
                } else {
                    request.setAttribute("ERROR", "Can't insert new user");
                }
            } else {
                request.setAttribute("errorGoogle", accountGoogleError);
            }
        } catch (Exception e) {
            System.out.println("Error at AuthenLoginGoogleController with ERROR: " + e.toString());
            request.setAttribute("ERROR", "Error at AuthenLoginGoogleController");
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
