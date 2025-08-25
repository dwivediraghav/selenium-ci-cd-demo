package mailautomate;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailAutomation {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Gmail
            driver.get("https://www.microsoft.com/en-in/microsoft-365/outlook/email-and-calendar-software-microsoft-outlook");
            
            // Log in to Gmail
            
            driver.findElement(By.xpath("//div[@class='button-group']//a[@id='action-oc5b26']")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Set<String> windows=driver.getWindowHandles();
    		Iterator<String>it=windows.iterator();
    		String parentId = it.next();
    		String childId = it.next();
    		driver.switchTo().window(childId);
            Thread.sleep(3000);
            WebElement emailField = driver.findElement(By.id("i0116"));
            emailField.sendKeys("raghavdwi998@outlook.com");
            driver.findElement(By.id("idSIButton9")).click();

            // Wait for the next page to load and enter the password
            Thread.sleep(2000); // Adjust sleep as necessary
            WebElement passwordField = driver.findElement(By.id("i0118"));
            passwordField.sendKeys("Raghav1998@");
            driver.findElement(By.id("idSIButton9")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("acceptButton")).click();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.urlContains("outlook.live.com/mail/"));
            
            WebElement composeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ms-OverflowSet-item.ribbonOverflowItem.item-174 > div.wrapperElement-314 > div.splitButtonContainer-217[aria-label='New mail']")));
            composeButton.click();
           /* // Wait for the mailbox to load
            Thread.sleep(5000); // Adjust sleep as necessary
            
            // Click on the Compose button
            WebElement composeButton = driver.findElement(By.cssSelector(".T-I.T-I-KE.L3"));
            composeButton.click();

            // Wait for the compose window to appear
            Thread.sleep(2000); // Adjust sleep as necessary
            
            // Fill in the recipient, subject, and body of the email
            WebElement toField = driver.findElement(By.name("to"));
            toField.sendKeys("recipient-email@gmail.com");

            WebElement subjectField = driver.findElement(By.name("subjectbox"));
            subjectField.sendKeys("Automated Email");

            WebElement bodyField = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
            bodyField.sendKeys("This is a test email sent using Selenium.");

            // Click on the Send button
            WebElement sendButton = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
            sendButton.click();

            // Wait for the email to be sent
            Thread.sleep(5000);

            System.out.println("Email sent successfully!");*/

        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            // Close the browser
            driver.quit();
        }*/

	}

}
