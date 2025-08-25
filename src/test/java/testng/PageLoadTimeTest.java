package testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void measureLoadTime() {
        long start = System.currentTimeMillis();

        driver.get("https://arunachal.mygov.in/");

        long end = System.currentTimeMillis();
        System.out.println("⏱ Total time by driver.get() = " + (end - start) / 1000 + " seconds");

        // Use JS to extract timings from browser
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object domContentLoaded = js.executeScript(
            "return window.performance.timing.domContentLoadedEventEnd - window.performance.timing.navigationStart;"
        );
        Object loadEvent = js.executeScript(
            "return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;"
        );

        System.out.println("📌 DOMContentLoaded: " + (Long) domContentLoaded / 1000 + " seconds");
        System.out.println("📌 Load Event: " + (Long) loadEvent / 1000 + " seconds");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
