package test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//static dropdown
//		WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		
//		Select dropdown = new Select(staticdropdown);
//		dropdown.selectByIndex(3);
		
		
		//dyamic dropdown
//		
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		
//		driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//a[@value='IXB'])[2]")).click();
		
		
		//auto suggest dropdown
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options=  driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(WebElement option :options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			}
				
			
				
			
		}
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
