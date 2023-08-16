package controller;

import controller.component.ItemListController;
import controller.component.ItemViewController;

public class HandlerMapping {

	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping() {} 
	
	public static HandlerMapping getInstance() {
		return handler;
	}

	public Controller createController(String command) {
		
		Controller controller = null;
		
		if(command.equals("itemList.do")) {
			controller = new ItemListController();
		}
		else if(command.equals("itemView.do")) {
			controller = new ItemViewController();
		}
//			else if(command.equals("login.do")) {
//			controller = new LoginController();
//		}else if(command.equals("update.do")) {
//			controller = new UpdateController();
//		}else if(command.equals("logout.do")) {
//			controller = new LogoutController();
//		}else if(command.equals("allshow.do")) {
//			controller = new AllshowController();
//		}else if(command.equals("idcheck.do")) {
//			controller = new IdcheckController();
//		}
		
		return controller;
	}
	
}
