package basicjavacode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pagespeed.web.dev/analysis/https-www-paisabazaar-com/8y7phuzz58?form_factor=mobile");
		WebElement scoreElement = driver.findElement(By.cssSelector("a.lh-gauge__wrapper>div.lh-gauge__percentage"));
		 System.out.println(scoreElement.getText());   
		

	}

}
