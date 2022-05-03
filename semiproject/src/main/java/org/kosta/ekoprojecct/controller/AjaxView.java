package org.kosta.ekoprojecct.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ajax 통신시 응답을 위한 View 
 */
@WebServlet("/AjaxView")
public class AjaxView extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getAttribute("responsebody"));
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getAttribute("responsebody"));
		out.close();
	}
}






