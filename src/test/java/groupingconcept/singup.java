package groupingconcept;

import org.testng.annotations.Test;

public class singup {
	@Test(priority=1,groups= {"sanity"})
	void singupusingfb() {
		System.out.println("singup with fb is working");
	}
	@Test(priority=2,groups= {"sanity"})
	void singuptwitter() {
		System.out.println("singup with the twitter is working");
	}
	@Test(priority=3,groups= {"sanity"})
	void singupinsta() {
		System.out.println("singup with the insta is working");
	}

}
