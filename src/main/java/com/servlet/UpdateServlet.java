package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.film.Film;
import com.service.JDBCService;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Film fm = new Film();
		fm.setFilm_id(Integer.parseInt(req.getParameter("film_id"))); 
		fm.setTitle(req.getParameter("title")); 
		fm.setDescription(req.getParameter("description"));
		fm.setLanguage_name(req.getParameter("language_name"));
//		System.out.println(id);
		JDBCService js = new JDBCService();
		int id =js.addressid(req.getParameter("language_name"));
		
		js.update(fm,id);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/ShowServlet");
		rd.forward(req, resp);
	}
	

}