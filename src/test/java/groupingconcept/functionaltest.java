package groupingconcept;

import org.testng.annotations.Test;

public class functionaltest {
	@Test(priority=1,groups= {"sanity","regression"})
	void testfunctional()
	{
		System.out.println("functioanl is working ");
	}
	@Test(priority=1,groups= {"sanity","regression"})
	void testfunctionamodel()
	{
		System.out.println("functioanl is  gud shape ");
	}

}
