package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paramtest {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) throws InterruptedException {
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default :System.out.println("Invalid broser");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
@Test(priority=1)
void testlogo(){
	boolean status=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img")).isDisplayed();
	Assert.assertEquals(status, true);
	
}
@Test(priority=2)
void testTitle(){
	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	
}
@Test(priority=3)
void testURL(){
	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
}
@AfterClass()
void tear(){
	driver.close();
	
}
}
