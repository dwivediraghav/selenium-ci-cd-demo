package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sslcertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		

	}

}
