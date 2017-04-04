package tim.at.cronn;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class HelloWorldTest {
	
	@Test
	public void testMakeHelloWorldString(){
		
		String s = HelloWorld.makeHelloWorldString();
		assertEquals("Hello World!", s);
	}
	
	
	@Test
	public void testMakeUser() {
		String[] names = {"Hans", "Sebastian"};
		int[] ages = {22, 36};
		for(int i = 0; i < names.length; i++) {
			User u = HelloWorld.makeUser(names[i], ages[i]);
			assertEquals(names[i], u.name);
			int ageInMonth = ages[i] * 12;
			assertEquals(ageInMonth, u.ageInMonth);
		}
		
	}
	
}
