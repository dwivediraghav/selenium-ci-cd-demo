package exceltest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pledgemygov {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://pledge.mygov.in/wcd-2024/");
		driver.findElement(By.className("pledge-btn")).click();

		//WebElement staticName = driver.findElement(By.name("prefix"));
        //Select date = new Select(staticName);
        //date.selectByValue("Smt");
        
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("prefix")));

         // Use Select to interact with the dropdown
         Select dropdown = new Select(dropdownElement);
         dropdown.selectByValue("Smt");
         driver.findElement(By.name("name")).sendKeys("Raghav");
         WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
         maleRadioButton.click();
         driver.findElement(By.name("dob")).sendKeys("01-11-2022");
         driver.findElement(By.name("pincode")).sendKeys("210205");
         driver.findElement(By.name("identity")).sendKeys("9198884232");
         driver.findElement(By.className("btn")).click();
         WebElement dropdownElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lang")));

         // Use Select to interact with the dropdown
         Select dropdown1 = new Select(dropdownElement1);
         dropdown1.selectByValue("en");
         driver.findElement(By.className("btn")).click();
         
		

	}

}
