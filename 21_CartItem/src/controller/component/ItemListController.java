package controller.component;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemListController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		
		ArrayList<Item> list = new ArrayList<Item>();
		list = ItemDAO.getInstance().getAllItem();
		String path = "index.jsp";
		
//		int val = Integer.parseInt(request.getParameter("val"));
		
//		System.out.println(val);
		
		if(list!=null) {
			
			session.setAttribute("list", list);
			path = "itemList.jsp";
		}
		
		return new ModelAndView(path);
	}
	
}
