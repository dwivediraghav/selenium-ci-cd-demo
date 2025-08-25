package testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

public class ReferralCodeLoginTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @DataProvider(name = "stateSites")
    public Object[][] stateSites() {
        return new Object[][]{
            {"https://up.mygov.in/"},
            {"https://mp.mygov.in/"},
            {"https://arunachal.mygov.in/"},
            {"https://assam.mygov.in/"},
            {"https://chhattisgarh.mygov.in/"},
            {"https://haryana.mygov.in/"}
            
        };
    }

    @Test(dataProvider = "stateSites")
    public void checkReferralCode(String site) throws IOException {
        try {
            driver.get(site);

            // Ensure login button exists
            if (driver.findElements(By.cssSelector(".ac-login")).isEmpty()) {
                throw new RuntimeException("Login button not found for: " + site);
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ac-login"))).click();

            // Handle multiple login form possibilities
            try {
                wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("edit-name")),
                    ExpectedConditions.visibilityOfElementLocated(By.name("name")),
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='text']"))
                ));
            } catch (TimeoutException te) {
                throw new RuntimeException("Login form not found for: " + site);
            }

            // Fill login username field (try in order)
            if (!driver.findElements(By.id("edit-name")).isEmpty()) {
                driver.findElement(By.id("edit-name")).sendKeys("raghav.dwivedi@mygov.in");
            } else if (!driver.findElements(By.name("name")).isEmpty()) {
                driver.findElement(By.name("name")).sendKeys("raghav.dwivedi@mygov.in");
            } else {
                driver.findElement(By.cssSelector("input[type='text']")).sendKeys("raghav.dwivedi@mygov.in");
            }
            if (!driver.findElements(By.id("edit-pass")).isEmpty()) {
                driver.findElement(By.id("edit-pass")).sendKeys("Raghav2295@");
            }

            // Submit login
            if (!driver.findElements(By.id("edit-submit")).isEmpty()) {
                driver.findElement(By.id("edit-submit")).click();
            } else if (!driver.findElements(By.cssSelector("button[type='submit']")).isEmpty()) {
                driver.findElement(By.cssSelector("button[type='submit']")).click();
            }

            // Navigate to profile → edit → referral code
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".views-field-name > .field-content"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/edit/main']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".referal_code > a"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".referal_code")));

            takeScreenshot(site.replace("https://", "").replace("/", ""));

        } catch (Exception e) {
            System.out.println("Test failed for site: " + site + " - " + e.getMessage());
            takeScreenshot(site.replace("https://", "").replace("/", "") + "_error");
            throw e;
        }
    }

    public void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        FileUtils.copyFile(src, new File("./screenshots/" + fileName + "_" + timestamp + ".png"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
