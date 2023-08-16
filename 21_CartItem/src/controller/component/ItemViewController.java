package controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = "itemView.jsp";
		
		int val = Integer.parseInt(request.getParameter("val"));
		
		System.out.println(val);
		request.setAttribute("val", val);
		
		return new ModelAndView(path);
		
	}

	
	
}
