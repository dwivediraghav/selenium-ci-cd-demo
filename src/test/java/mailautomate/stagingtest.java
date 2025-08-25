package mailautomate;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stagingtest {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        driver.get("https://demoauth.mygov.in/user/register");
		// TODO Auto-generated method stub

	}

}
