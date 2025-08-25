package groupingconcept;

import org.testng.annotations.Test;

public class login {
	@Test(priority=1,groups= {"regression"})
	void loginfb() {
		System.out.println("singup with fb is working");
	}
	@Test(priority=2,groups= {"regression"})
	void logintwitter() {
		System.out.println("singup with the twitter is working");
	}
	@Test(priority=3,groups= {"regression"})
	void logininsta() {
		System.out.println("singup with the insta is working");
	}

}
