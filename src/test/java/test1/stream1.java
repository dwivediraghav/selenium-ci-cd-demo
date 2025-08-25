package test1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement>values=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> value=values.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(value);
		List<String>price;
		do {
			List<WebElement>row=driver.findElements(By.xpath("//tr/td[1]"));
		price = row.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggies(s)).
		collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		

	}

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub	
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
		
	}

}
