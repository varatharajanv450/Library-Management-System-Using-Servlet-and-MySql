package com.model.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.beans.BookBean;
import com.model.beans.IssueBookBean;
import com.model.dao.BookDao;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<IssueBookBean> list=BookDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Return Status</th></tr>");
		for(IssueBookBean bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
