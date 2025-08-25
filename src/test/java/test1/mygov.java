package test1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mygov {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); // Block popups
        options.addArguments("--disable-notifications");  // Disable browser notifications
        options.addArguments("--start-maximized"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.mygov.in/");
		
		driver.findElement(By.className("login-reg-icon")).click();
		//driver.findElement(By.linkText("X")).click();
		driver.findElement(By.className("ac-login")).click();
		driver.findElement(By.id("edit-name")).sendKeys("raghav.dwivedi@mygov.in");
		driver.findElement(By.id("edit-pass")).sendKeys("Raghav2209@");
		driver.findElement(By.id("edit-submit")).click();
		
		

	}

}
