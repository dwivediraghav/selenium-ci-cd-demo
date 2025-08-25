package exceltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class mygovregistration {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoauth.mygov.in/user/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("edit-full-name")).sendKeys("Raghav");
		driver.findElement(By.id("edit-email")).sendKeys("g.dei@mygov.in");
		WebElement staticdropdown=driver.findElement(By.id("edit-gateway-country"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByValue("213");
		//driver.findElement(By.id("edit-number")).sendKeys("6203243461");
		
		WebElement staticdate=driver.findElement(By.id("edit-links-fieldset-date"));
		Select date = new Select(staticdate);
		date.selectByValue("10");
		
		WebElement staticmonth=driver.findElement(By.id("edit-links-fieldset-month"));
		Select month = new Select(staticmonth);
		month.selectByValue("May");
		
		WebElement staticyear=driver.findElement(By.id("edit-links-fieldset-year"));
		Select year = new Select(staticyear);
		year.selectByValue("2024");
		
		WebElement staticgender=driver.findElement(By.id("edit-gender"));
		Select gender = new Select(staticgender);
		gender.selectByValue("female");
		
		 boolean useReferralCode = false;  // Set to false for the second test case

	        // If block to handle both scenarios
	        if (useReferralCode) {
	            System.out.println("Test Case: With Referral Code");
	            WebElement ref = driver.findElement(By.id("edit-referal-markup"));
	            ref.click();  // Click the checkbox to enable referral input

	            // Enter referral code only if checkbox is clicked
	            driver.findElement(By.id("edit-referal-code")).sendKeys("YOLIP");
	        } else {
	            System.out.println("Test Case: Without Referral Code");
	            // Do nothing, proceed without clicking the referral checkbox
	        }

	        // Submit the form
	        driver.findElement(By.id("edit-submit")).click();
	        Thread.sleep(3000);
	        
	    //String errmsg = driver.findElement(By.xpath("//div[@class='messages error']")).getText();
	    		
	    
	    //String errmsg = driver.findElement(By.xpath("//body/div[@id='auth_box']/div[@id='middle_part']/div[2]/h2")).getText();
	    //System.out.println(errmsg);
	    //driver.quit();
	    
	    
		//String sucessmsg = driver.findElement(By.xpath("//div[@class='messages status']/ul")).getText();
		//System.out.println(sucessmsg);
		/*String actualMessage = sucessmsg.replace("Status message\n", "");  // Remove the "Status message" prefix
		Assert.assertEquals(actualMessage, "OTP has been sent to your emailid\nOTP has been sent to your mobile");*/
		
		
		
		driver.findElement(By.id("edit-otp")).sendKeys("123456");
		driver.findElement(By.id("edit-submit")).click();
		
		//String sucessmsg1 = driver.findElement(By.xpath("//body/div[@id='auth_box']/div[@id='middle_part']/div[2]")).getText();
		//System.out.println(sucessmsg1);
		
		
	
	}

}
