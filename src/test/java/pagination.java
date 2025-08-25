import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class pagination {

    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open the URL
        driver.get("https://www.mygov.in/home/blog/");
        
        // WebDriverWait setup for waiting conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Loop through pagination
        while (true) {
            try {
                // Wait for the loading spinner to disappear (if applicable)
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajax-progress-throbber")));
                
                // Locate the "Load More" button
                WebElement loadMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pager pager-load-more']//a")));
                
                // Click the "Load More" button
                System.out.println("Clicking on 'Load More' button...");
                loadMoreButton.click();
                
                // Wait for content to load after clicking "Load More"
                Thread.sleep(5000); // You can also use WebDriverWait to wait for specific elements to load
                
            } catch (NoSuchElementException e) {
                // Exit the loop if no more "Load More" button is found
                System.out.println("No more 'Load More' buttons found, exiting.");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Close the driver after pagination is done
        
    }
}
