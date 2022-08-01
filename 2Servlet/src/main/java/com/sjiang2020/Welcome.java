package com.sjiang2020;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Object attribute = req.getAttribute("KEY");
		String username = req.getParameter("username");
		
		if(attribute.equals("FORWARD")) {
			
			res.getWriter().println("Welcome " + username + ", " + " you are verified!!");
		}
		
	

	}
	
	

}
