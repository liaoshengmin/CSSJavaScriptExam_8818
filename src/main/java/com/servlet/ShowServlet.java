package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.film.Customer;
import com.film.Film;
import com.service.JDBCService;

public class ShowServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCService js = new JDBCService();
		List<Customer> list =js.customer();
		req.getSession().setAttribute("list", list);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
		
	}
	
	

}
