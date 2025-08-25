package test1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class firsttestcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mygov.in/");
		System.out.println(driver.getTitle());
		driver.close();
	
	}

}
