package client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

public class DispatcherMainTest {

	
	public static void main(String[] args) {
		String command = "INSERT";
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.creatAction(command);
		
		action.execute();
	}
}
