package brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class campus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://campus.mygov.in/");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links"+links.size());
		int noofbrokenlink=0;
		for (int i = 0; i < links.size(); i++) {
		    try {
		        WebElement linkElement = links.get(i); // Get element fresh each iteration
		        String hrefValue = linkElement.getAttribute("href");
		        
		        if (hrefValue == null || hrefValue.isEmpty()) {
		            System.err.println("href value is empty");
		            continue;
		        }

		        try {
		            URL linkUrl = new URL(hrefValue); // Convert to URL format
		            HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
		            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		            conn.connect();

		            int responseCode = conn.getResponseCode();
		            System.out.println(hrefValue + " ===> Response Code: " + responseCode);

		            if (responseCode >= 400) {
		                System.out.println(hrefValue + " =======> Broken link");
		                noofbrokenlink++;
		            } else {
		                System.out.println(hrefValue + " =======> Link is not broken");
		            }
		        } catch (Exception e) {
		            System.err.println("Exception: " + e.getMessage());
		        }

		    } catch (StaleElementReferenceException e) {
		        System.err.println("StaleElementReferenceException caught, skipping this element.");
		    }
		}
		System.out.println("no of broken link"+noofbrokenlink);


	}

}
