package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in login");
		//getParameter method used for get the input from jsp in input field
		String username = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if(username.equals("admin") && pass.equals("1234")) {
			response.sendRedirect("home.jsp");
		} 
		else {
			String msg = "Invalid Credential...!!!";
			//setting data to request
			request.setAttribute("msg", msg);
			//set request dispatcher
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			
			//Forwarding request and response
			rd.forward(request, response);
//			response.sendRedirect("index.jsp");
		}
	}

}
