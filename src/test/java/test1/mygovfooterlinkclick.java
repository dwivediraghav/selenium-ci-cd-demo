package test1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class mygovfooterlinkclick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.mygov.in/");
		WebElement driver1 = driver.findElement(By.className("footer-top-wrapper"));
		System.out.println(driver1.findElements(By.tagName("a")).size());
		WebElement driver2 = driver1.findElement(By.cssSelector(".flink-block.footer-act-links"));
		System.out.println(driver2.findElements(By.tagName("a")).size());
		for (int i =1;i<driver2.findElements(By.tagName("a")).size();i++)
		{
			String a1=Keys.chord(Keys.CONTROL,Keys.ENTER);
			driver2.findElements(By.tagName("a")).get(i).sendKeys(a1);
		}
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it =abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
			
			
		
			
		

	}

}
