package com.sjiang2020;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		req.setAttribute("KEY", "FORWARD");
		
		RequestDispatcher rd = req.getRequestDispatcher("welcome");
		rd.forward(req, res);
		
		
	
	}
	
	

}
