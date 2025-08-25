package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement driver1=driver.findElement(By.id("gf-BIG"));
		System.out.println(driver1.findElements(By.tagName("a")).size());
		WebElement driver2=driver1.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(driver2.findElements(By.tagName("a")).size());
		for(int i=1; i<driver2.findElements(By.tagName("a")).size(); i++)
		{
			String a1=Keys.chord(Keys.CONTROL,Keys.ENTER);
		    driver2.findElements(By.tagName("a")).get(i).sendKeys(a1);
		}
		

	}

}
