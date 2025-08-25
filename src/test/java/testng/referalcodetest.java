package testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

public class referalcodetest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //driver = new ChromeDriver();
    	ChromeOptions options = new ChromeOptions();
    	options.setPageLoadStrategy(PageLoadStrategy.EAGER); 
    	// waits only for DOMContentLoaded, not for all JS/CSS/images
    	 driver = new ChromeDriver(options);
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
            {"https://jharkhand.mygov.in/"},
            {"https://himachal.mygov.in/"}
        };
    }

    @Test(dataProvider = "stateSites")
    public void checkReferralCode(String site) throws IOException {
        try {
            driver.get(site);

            // ---- Login button (English/Hindi fallback) ----
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ac-login"))).click();
            } catch (Exception e) {
                if (!driver.findElements(By.xpath("//a[contains(text(),'Login') or contains(text(),'लॉगिन')]")).isEmpty()) {
                    driver.findElement(By.xpath("//a[contains(text(),'Login') or contains(text(),'लॉगिन')]")).click();
                } else {
                    throw new RuntimeException("Login button not found (English/Hindi) for: " + site);
                }
            }

            // ---- Handle possible redirect to secure.mygov.in ----
            wait.until(driver -> driver.getCurrentUrl().contains("mygov.in"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("secure.mygov.in")) {
                System.out.println("Redirected to secure.mygov.in login for: " + site);
            }

            // If login opens in new window, switch to it
            String originalWindow = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // ---- Login form ----
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("edit-name")),
                ExpectedConditions.visibilityOfElementLocated(By.name("name")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='text']"))
            ));

            // Username
            if (!driver.findElements(By.id("edit-name")).isEmpty()) {
                driver.findElement(By.id("edit-name")).sendKeys("raghav.dwivedi@mygov.in");
            } else if (!driver.findElements(By.name("name")).isEmpty()) {
                driver.findElement(By.name("name")).sendKeys("raghav.dwivedi@mygov.in");
            } else {
                driver.findElement(By.cssSelector("input[type='text']")).sendKeys("raghav.dwivedi@mygov.in");
            }

            // Password
            if (!driver.findElements(By.id("edit-pass")).isEmpty()) {
                driver.findElement(By.id("edit-pass")).sendKeys("Raghav2295@");
            }

            // Submit
            if (!driver.findElements(By.id("edit-submit")).isEmpty()) {
                driver.findElement(By.id("edit-submit")).click();
            } else if (!driver.findElements(By.cssSelector("button[type='submit']")).isEmpty()) {
                driver.findElement(By.cssSelector("button[type='submit']")).click();
            }

            // ---- Navigate to Profile (fallback Hindi/English) ----
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".views-field-name > .field-content"))).click();
            } catch (Exception e) {
                if (!driver.findElements(By.xpath("//a[contains(text(),'Profile') or contains(text(),'प्रोफाइल')]")).isEmpty()) {
                    driver.findElement(By.xpath("//a[contains(text(),'Profile') or contains(text(),'प्रोफाइल')]")).click();
                }
            }

            // ---- Edit Profile (fallback Hindi/English) ----
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/edit/main']"))).click();
            } catch (Exception e) {
                if (!driver.findElements(By.xpath("//a[contains(text(),'Edit Profile') or contains(text(),'प्रोफाइल सम्पादित करें')]")).isEmpty()) {
                    driver.findElement(By.xpath("//a[contains(text(),'Edit Profile') or contains(text(),'प्रोफाइल सम्पादित करें')]")).click();
                }
            }

            // ---- Referral Code (fallback Hindi/English) ----
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".referal_code > a"))).click();
            } catch (Exception e) {
                if (!driver.findElements(By.xpath("//a[contains(text(),'Referral Code') or contains(text(),'रेफरल कोड')]")).isEmpty()) {
                    driver.findElement(By.xpath("//a[contains(text(),'Referral Code') or contains(text(),'रेफरल कोड')]")).click();
                }
            }

            // Wait for Referral Code section to appear
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
