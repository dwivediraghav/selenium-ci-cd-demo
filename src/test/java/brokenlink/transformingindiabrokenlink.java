package brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class transformingindiabrokenlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://transformingindia.mygov.in/");
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
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
			conn.connect();
			int responseCode = conn.getResponseCode();
            System.out.println(hrefvalue + " ===> Response Code: " + responseCode);
			if(conn.getResponseCode()>=400)
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
