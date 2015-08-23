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
import com.film.Language;
import com.service.JDBCService;

public class ShowOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("typeid");
		Integer customerid =Integer.parseInt(id); 
		
		JDBCService js = new JDBCService();
		Customer cu = js.showOne(customerid);
		req.getSession().setAttribute("cu", cu);
		List<Customer> list =js.lang();
		req.getSession().setAttribute("lanlist", list);
		
		List listname = js.addressname();
		req.getSession().setAttribute("listname", listname);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/update.jsp");
		rd.forward(req, resp);
	}
	

}