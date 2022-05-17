/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.eti.emanuel.bookstoreweb.controller;

import com.eti.emanuel.bookstoreweb.model.bean.User;
import com.eti.emanuel.bookstoreweb.model.dao.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author devsys-a
 */
public class UserServlet extends HttpServlet {

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
        
        String action = request.getPathInfo();
        Logger.getLogger(UserServlet.class.getName()).log(Level.INFO, "Path solicitado (0)", action);
        
                if(action == null){
                    action = "/initial";
                }
                
                try{
                    switch(action){
                        case "/new":
                            newRegister(request, response);
                            break;
                            
                        case "/register":
                            showNewRegister(request, response);
                            break;
                            
                        case "/list":
                            
                        default:
                            Logger.getLogger(UserServlet.class.getName()).log(Level.INFO, "Carregando a ShowInicial...");
                            listUser(request, response);
                    
                    }
                }catch (Exception ex){                            
                }
                    
    }
    
    private void listUser (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        UserDAO userDAO = new UserDAO();
        List<User> listaUser = userDAO.getResults();
        
        Logger.getLogger(UserServlet.class.getName()).log(Level.INFO, "Lista de Usuarios.... carregando {0}", listaUser.size());
        request.setAttribute("listaUser", listaUser);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewRegister (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
            
            UserDAO userDAO = new UserDAO();
            User novoCadastro = new User();

            novoCadastro.setEmail(request.getParameter("userEmail"));///nome que determina o input 
            novoCadastro.setPassword(request.getParameter("userPassword"));
            novoCadastro.setFullName(request.getParameter("userFullname"));
        
            userDAO.create(novoCadastro);
            response.sendRedirect("listUser");

    }
    
    private void newRegister(HttpServletRequest request, HttpServletResponse response )
            throws IOException,  ServletException{
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
            dispatcher.forward(request, response);
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
