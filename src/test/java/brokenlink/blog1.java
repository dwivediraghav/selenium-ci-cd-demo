package brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class blog1 {

    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://blog.mygov.in/");
        driver.manage().window().maximize();

        // Fetch all links and store hrefs
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        // Extract valid hrefs into a list
        List<String> hrefValues = new ArrayList<>();
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty() && !href.startsWith("javascript")) {
                hrefValues.add(href);
            }
        }

        int brokenLinkCount = 0;

        // Process each valid href
        for (String hrefValue : hrefValues) {
            try {
                URL linkUrl = new URL(hrefValue);
                HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                conn.setConnectTimeout(5000); // Timeout for connections
                conn.connect();
                int responseCode = conn.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(hrefValue + " ===> Broken link");
                    brokenLinkCount++;
                } else {
                    System.out.println(hrefValue + " ===> Link is not broken");
                }
            } catch (Exception e) {
                System.err.println("Exception for " + hrefValue + ": " + e.getMessage());
            }
        }

        System.out.println("Total broken links: " + brokenLinkCount);

        // Quit the browser
        driver.quit();
    }
}
