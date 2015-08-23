package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.JDBCService;

public class GetAddressServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCService js = new JDBCService();
		List listname1=js.addressname();
		req.getSession().setAttribute("listname1", listname1);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/add.jsp");
		rd.forward(req, resp);
		
	}
	
	
	

}
