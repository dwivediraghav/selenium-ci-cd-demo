package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class svglocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button' and @tabindex='0']/*[@class='css-1dbjc4n']")).click();
		driver.findElement(By.xpath("//*[text()='Select Date']")).click();
	}

}
