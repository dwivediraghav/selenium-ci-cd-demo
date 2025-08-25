package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
	WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Optional: Disable waiting for full page load
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NONE);
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ac-login"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-name")))
            .sendKeys("raghav.dwivedi@mygov.in");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-pass")))
        .sendKeys("Raghav5@");
        
        driver.findElement(By.id("edit-submit")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".views-field-name > .field-content"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/edit/main']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".referal_code > a"))).click();

        // Assertion: referral code section should be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".referal_code")));

        // Screenshot with timestamp
        String siteName = driver.getCurrentUrl()
                .replace("https://", "")
                .replace("http://", "")
                .split("\\.")[0];
        String timestamp = java.time.LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
        ((org.openqa.selenium.TakesScreenshot) driver)
                .getScreenshotAs(org.openqa.selenium.OutputType.FILE)
                .renameTo(new java.io.File(siteName + "-referral-page-" + timestamp + ".png"));
    }

    @Test
    public void rajasthanLoginCheck() {
        driver.get("https://mp.mygov.in");
        login();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

