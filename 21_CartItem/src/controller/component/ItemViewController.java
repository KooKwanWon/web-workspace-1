package controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Arrays;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = "itemView.jsp";
		
		
		int val = Integer.parseInt(request.getParameter("val"));

		Item item = new Item();
		
		
		if(ItemDAO.getInstance().updateRecordCount((val+1))) {
			
			item = ItemDAO.getInstance().getItem((val+1));
			
		}
		
		request.setAttribute("val", val);
		request.setAttribute("item", item);
		
		return new ModelAndView(path);
		
	}

	
	
}
