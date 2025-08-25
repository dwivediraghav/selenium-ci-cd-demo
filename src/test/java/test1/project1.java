package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Raghav");
		driver.findElement(By.name("email")).sendKeys("Raghav.di@mygov.in");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Raghav");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1'][1]"));
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("01/01/1998");
		driver.findElement(By.className("btn-success")).click();
		System.out.println(driver.findElement(By.className("alert-success")).getText());
		

		
		

	}

}
