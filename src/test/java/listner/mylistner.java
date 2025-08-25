package listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class mylistner implements ITestListener {
	
	public void onStart​(ITestContext context) {
		
		System.out.println("test got started    ");
		//System.out.flush();
	}
	
	public void onTestStart​(ITestResult result) {
	System.out.println("test  start");
	//System.out.flush();
}
	public void onTestSuccess​(ITestResult result) {
		System.out.println("test pass");
	
}
	public void onTestFailure​(ITestResult result) {
	System.out.println("test got failed   ");
}
	public void onTestSkipped​(ITestResult result) {
		System.out.println("test got skipped  ");
		
	}
	public void onFinish​(ITestContext context) {
		System.out.println("test got finished ");
		
	}

}
