package com.eti.emanuel.bookstoreweb.controller;

import com.eti.emanuel.bookstoreweb.model.bean.User;
import com.eti.emanuel.bookstoreweb.model.dao.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author devsys-a
 */
public class UserLoginServlet extends HttpServlet {

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
        
        String auxEmail = request.getParameter("email");
        String auxPassword = request.getParameter("password");
        ///Variáveis acima pegam os dados inseridos nos forms
       UserDAO userDAO = new UserDAO();
       
       try {
           User user = userDAO.checkLogin(auxEmail, auxPassword);///Aqui é carregado o método checkLogin e retorna uma msg após a exxcução
           String destPag = "/loginPage.jsp";
           
           if (user != null) {
               HttpSession session = request.getSession();///cria session
               session.setAttribute("user", user);///Aqui é pendurado o par de chave key-value
               destPag = "/bstore/list";
               Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, 
                       "Usuario Logado: {0}", user.getEmail() + " | " + user.getFullName());
           } else {
               
               String msgAux = "Email ou Password inválido!!!";///retorna mensagem casi o método checklogin for null
               request.setAttribute("message", msgAux);
               
               Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, 
                       "Erro Login: {0}", auxEmail);
           }
           
           RequestDispatcher dispatcher = request.getRequestDispatcher(destPag);
           dispatcher.forward(request, response);
           
       }catch(ServletException ex){
           Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, 
                   "Servlet Exception na UserLoginServlet. {0}", ex);
           throw new ServletException(ex);
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
