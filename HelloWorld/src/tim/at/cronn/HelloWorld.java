
package tim.at.cronn;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeHelloWorldString());
		
	}


	
	static String makeHelloWorldString() {
		return "Hello World!";
	}

	public HelloWorld(){
		
	}
	
	public void HalloSagen(){
		
	}
	
	public static User makeUser(String name, int age) {
		User user = new User();
		user.name = name;
		user.ageInMonth= age * 12;
		return user;
	}
}
