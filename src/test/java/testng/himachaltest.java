package testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class himachaltest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // better than NONE
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    /*@DataProvider(name = "stateSites")
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
    }*/

    @Test()
    public void loginTest() throws InterruptedException, IOException {
        String url = "https://himachal.mygov.in/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            try {
                driver.get(url);
            } catch (TimeoutException e) {
                System.out.println("⚠️ Initial page load timed out, retrying once...");
                driver.navigate().refresh();
            }

            // ✅ Wait for login button after load/refresh
            WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("ac-login"))
            );

            // Scroll to avoid sticky header blocking
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", loginBtn
            );

            try {
                new Actions(driver).moveToElement(loginBtn).click().perform();
                System.out.println("✅ Clicked login button with Actions");
            } catch (ElementClickInterceptedException e) {
                System.out.println("⚠️ Normal click failed, retrying with JS click...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
                System.out.println("✅ Clicked login button using JavaScript");
            }

            // ✅ Wait for login form fields
            WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("edit-name"))
            );
            WebElement password = driver.findElement(By.id("edit-pass"));
            WebElement submit   = driver.findElement(By.id("edit-submit"));

            // 🔑 Replace with your real credentials
            username.sendKeys("Raghav.dwivedi@mygov.in");
            password.sendKeys("Raghav2295@");
            submit.click();
            System.out.println("✅ Login form submitted");

        } catch (TimeoutException e) {
            System.out.println("❌ Login button or fields not found after retry");
        }
        //System.out.println(driver.getPageSource());
        //driver.findElement(By.className("field-content")).click();
        driver.findElement(By.xpath("//span[@class='field-content']"));

        //driver.findElement(By.xpath("//a[@title='Edit Profile']")).click();
        //driver.findElement(By.xpath("//a[contains(@href,'/edit/main')]")).click();
        //WebElement editProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/edit/main')]")));
        //editProfile.click();
        WebElement editProfile = driver.findElement(By.xpath("//a[contains(@href,'/edit/main')]"));
        System.out.println("Displayed? " + editProfile.isDisplayed());
        System.out.println("Enabled? " + editProfile.isEnabled());



        //driver.findElement(By.xpath("//a[@title='Referral Code']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'referral')]")).click();

        Thread.sleep(2000);  // Better: use WebDriverWait for a specific element

     // Take screenshot
     TakesScreenshot ts = (TakesScreenshot) driver;
     File src = ts.getScreenshotAs(OutputType.FILE);

     // Save file to local system
     File dest = new File("C:\\Users\\hp\\Documents\\referral_screenshot.png");
     org.openqa.selenium.io.FileHandler.copy(src, dest);

     System.out.println("✅ Screenshot captured at: " + dest.getAbsolutePath());
    }}
