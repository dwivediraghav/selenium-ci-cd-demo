package test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpageassign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicitlywait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		 driver.findElement(By.xpath("//select[@class='form-control']/option[text()='Consultant']")).click();
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		 driver.findElement(By.id("okayBtn")).click();
		 driver.findElement(By.id("signInBtn")).click();
		 Thread.sleep(3000);
		 List<WebElement> product=driver.findElements(By.className("zmdi"));
		 for(int i=0;i<product.size();i++)
		 {
			 product.get(i).click();
		 }
		 driver.findElement(By.partialLinkText("Checkout")).click();
		 

	}

}
