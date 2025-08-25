package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovidertest {
	WebDriver driver;
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		boolean status=driver.findElement(By.xpath("//li[@class='dropdown']//a[@title='My Account']")).isDisplayed();
		System.out.println(status);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='dropdown']//a[@title='My Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[5]")).click();
	}
	@DataProvider(name="dp",indices= {0,2})
	Object[][] logindata(){
		Object data[][]= {
				{"abc@gmail.com","test@123"},
				{"xyz@gmail.com","test@023"},
				{"john@gmail.com","test123"},
				{"pavanol123@gmail.com","test@123"},
				
				
		};
		return data;
	}

}
