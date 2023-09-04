package controller;

import controller.component.FindController;
import controller.component.JustPrintController;
import controller.component.allPrintController;

public class HandlerMapping {
	private static HandlerMapping hm = new HandlerMapping();
	public HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return hm;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
		}else if(command.equals("allprint.do")){
			controller = new allPrintController();
		}
		
		return controller;
	}
}
