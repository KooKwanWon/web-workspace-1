package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet
 */
@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		PrintWriter out = response.getWriter();
		
		String nick = request.getParameter("nick");
		
		System.out.println(nick);
		
		out.print("<br> Nick :: " + nick);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
