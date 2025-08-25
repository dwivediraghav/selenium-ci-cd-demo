package test1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicitlywait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
String[] iteamNeeded = {"Brocolli","Cucumber","Brinjal"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		additeams(driver,iteamNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		//explicity wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

       }
	public static void additeams(WebDriver driver,String[] iteamNeeded) {
		int j=0;
	List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
	for(int i=0;i<products.size();i++)
	{
		
		String[] name = products.get(i).getText().split("-");
		String a2=name[0].trim();
		List a1=Arrays.asList(iteamNeeded);
		if(a1.contains(a2))
		{
			j++;
			driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
			if(j==iteamNeeded.length)
			{
				break;
			}
		}
	}

  }
}
