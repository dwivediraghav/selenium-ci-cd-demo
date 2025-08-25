package testng;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class brokenmygovlink {
	@Test
	void brokenlink() {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.mygov.in/");
	driver.manage().window().maximize();
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("Total no of links"+links.size());
	int noofbrokenlink=0;
	for(WebElement linkElement:links)
	{
		String hrefvalue=linkElement.getAttribute("href");
		if(hrefvalue==null || hrefvalue.isEmpty())
		{
			System.err.println("href value is empty");
			continue;
		}
		try {
		URL linkurl=new URL(hrefvalue);//converted string value to URL  format
		HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();//open the connection to the server
		conn.connect();
		if(conn.getResponseCode()==400 || conn.getResponseCode()==404)
			{
			System.out.println(hrefvalue+"=======>Broken link");
			noofbrokenlink++;
			
			}
		else {
			System.out.println(hrefvalue+"=========>link is not broken");
			
		}
		}
		catch(Exception e)
		{
			System.err.println("Exception: " + e.getMessage());
		}
		
	}
	
	System.out.println("no of broken link"+noofbrokenlink);

	}
}
