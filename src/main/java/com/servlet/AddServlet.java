package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.film.Customer;
import com.service.JDBCService;

public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer cu = new Customer();
		cu.setFirst_name(req.getParameter("fname"));
		cu.setLast_name(req.getParameter("lname"));
		cu.setEmail(req.getParameter("email"));
		
		JDBCService js = new JDBCService();
		int id=js.addressid(req.getParameter("addressname"));
		js.add(cu, id);
		
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/ShowServlet");
		rd.forward(req, resp);
	}
	

}
