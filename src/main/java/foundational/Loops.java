package foundational;

import org.testng.annotations.Test;

public class Loops {

	@Test
	public void forLoops() {
		String[] planes = {"Piper", "Cessna", "Cirrus", "Grumman", "Beechcraft", "Socata"};
		for (int i = 0;i<planes.length;i++)
		{
			System.out.println(i + " " + planes[i]);
		}
		
		for (String plane : planes)
		{
			System.out.println(plane);
		}
		
//		String[] things = new String[] { "This", "That", "Other" };
//
//		for (int i = 0;i<things.length;i++)
//		{
//			System.out.println(things[i]);
//		}
//
//		for (String thing : things)
//		{
//			System.out.println(thing);
//		}
	}
}
