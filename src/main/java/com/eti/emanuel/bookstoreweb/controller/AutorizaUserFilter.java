/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eti.emanuel.bookstoreweb.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.eti.emanuel.bookstoreweb.model.bean.User;
import javax.servlet.Filter;

/**
 *
 * @author devsys-a
 */
    
   @ WebFilter(filterName = "AutorizaUserFilter", urlPatterns = {"/bstore/*"})
    public class AutorizaUserFilter implements Filter {
       
       ///monitora acionamentos
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
			"AutorizaUserFilter Iniciado!!!");
	}

	@Override
	public void destroy(){
	
		Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
			"AutorizaUserFilter Destruído!!!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
			
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		///Carrega a session caso exista.
		HttpSession session = httpRequest.getSession(false);
		boolean isUsuarioLogado = (session != null && session.getAttribute("user") != null);

		if (isUsuarioLogado) {
			// Tudo OK!! Usuario com session autorizado e segue a requisição.
			User userLogado = (User) session.getAttribute("user");
			Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
				"Usuario autenticado: {0}", userLogado.getEmail());

			Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
				"Carrega proximo Filtro ou Servlet - chain.doFilter()");
			
			chain.doFilter(request, response);
			
		} else {
			///ops... usuario não autenciado: Redirecionar para página de login.
			Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
				"Usuario não autencado: ");

			RequestDispatcher dispacher = request.getRequestDispatcher("/loginPage.jsp");////-*************
			dispacher.forward(request, response);
		}
		
		Logger.getLogger(AutorizaUserFilter.class.getName()).log(Level.INFO,
			"*** Pos-Filtro ***");		


		}

}

    

