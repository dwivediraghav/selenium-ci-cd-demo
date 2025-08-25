package testng;

import org.testng.annotations.Test;

public class firstcase {
	//all the test run on the basis of alphabetical order
	//if we used priority then  which test got the lowest priority it will run first
	@Test(priority=1)
	void openapp(){
		System.out.println("hello syystem");
		
	}
	@Test
	void login() {
		System.out.println("hello login");
	}

}
