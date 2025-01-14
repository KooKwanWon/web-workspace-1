package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		String command = requestURIList[requestURIList.length-1];
		System.out.println("Command :: " + command);
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
		
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
				
			}
		} catch (Exception e) {}
		
					
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}