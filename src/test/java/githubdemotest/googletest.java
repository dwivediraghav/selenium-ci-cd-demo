package githubdemotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class googletest {

    @Test   // ✅ This makes it a TestNG test method
    public void verifyGoogleTitle() {
        WebDriverManager.chromedriver().setup(); // automatically sets up ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        String title = driver.getTitle();

        Assert.assertTrue(title.contains("Google"), "Title should contain Google");

        driver.quit();
    }
}
