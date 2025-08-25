package listner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(mylistner.class)
public class listenertest {
	WebDriver driver;
	@BeforeClass
	void setup() throws InterruptedException {
		driver=new ChromeDriver();
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
	@Test(priority=3,dependsOnMethods= {"testURL"})
	void testTitle(){
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	@Test(priority=2)
	void testURL(){
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlivelogin");
		
	}
	@AfterClass()
	void tear(){
		driver.close();
		
	}

}
