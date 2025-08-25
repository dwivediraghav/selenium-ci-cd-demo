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

public class self4society {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://self4society.mygov.in/");
        driver.manage().window().maximize();
        
        // Get all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());
        int noOfBrokenLinks = 0;

        // Iterate through all links
        for (int i = 0; i < links.size(); i++) {
            try {
                // Refresh WebElement in every iteration to avoid StaleElementReferenceException
                WebElement linkElement = links.get(i);
                String hrefValue = linkElement.getAttribute("href");

                // Skip empty, null, or javascript: links
                if (hrefValue == null || hrefValue.isEmpty() || hrefValue.startsWith("javascript:")) {
                    System.err.println("Skipping invalid href value: " + hrefValue);
                    continue;
                }

                // Try connecting to the link
                try {
                    URL linkUrl = new URL(hrefValue); // Convert String to URL
                    HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection(); // Open connection
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                    conn.connect();
                    
                    int responseCode = conn.getResponseCode(); // Get response code
                    System.out.println(hrefValue + " ===> Response Code: " + responseCode);
                    
                    // Check if the response code indicates a broken link
                    if (responseCode >= 400) {
                        System.out.println(hrefValue + " =======> Broken link");
                        noOfBrokenLinks++;
                    } else {
                        System.out.println(hrefValue + " =========> Link is not broken");
                    }
                } catch (Exception e) {
                    System.err.println("Exception while checking the link: " + e.getMessage());
                }
            } catch (StaleElementReferenceException e) {
                // Handle stale element
                System.err.println("Encountered stale element reference at index " + i + ": " + e.getMessage());
                continue;
            }
        }

        // Print the number of broken links found
        System.out.println("Number of broken links: " + noOfBrokenLinks);
        
        
	}

}
