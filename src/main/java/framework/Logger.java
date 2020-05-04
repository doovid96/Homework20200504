package framework;

public class Logger {
	public static void writeInfo(String message) {
		System.out.println("Info:" + message);
	}
	
	public static void writeInfo(int message) {
		System.out.println(message);
	}
	
	public static void writeWarning(String message) {
		System.out.println("Warning:" + message);
	}
}
