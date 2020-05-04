package framework;

public class Action {
	
	public static void invoke(IAction action) {
		action.invoke();
	}
}
