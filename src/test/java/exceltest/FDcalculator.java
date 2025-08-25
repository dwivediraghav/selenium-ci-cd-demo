package exceltest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class FDcalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		String file=System.getProperty("user.dir")+"\\testdata\\calculate.xlsx";
		int row=excelutil.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=row;i++)
		{
			//read data from excel
			String pric=excelutil.getCellData(file, "Sheet1", i, 0);
			String rateofInterest=excelutil.getCellData(file, "Sheet1", i, 1);
			String per1=excelutil.getCellData(file, "Sheet1", i, 2);
			String per2=excelutil.getCellData(file, "Sheet1", i, 3);
			String fre=excelutil.getCellData(file, "Sheet1", i, 4);
			String exp_val=excelutil.getCellData(file, "Sheet1", i, 5);
			
			//pass above data in application
			driver.findElement(By.id("principal")).sendKeys(pric);
			driver.findElement(By.id("interest")).sendKeys(rateofInterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='CTR PT15']/a[1]")).click();
			
			//validation
			String act_val=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_val)==Double.parseDouble(act_val))
			{
				System.out.println("Test passed");
				excelutil.setCellData(file, "Sheet1", i, 7, "Passed");
				excelutil.fillGreenColor(file, "Sheet1", i, 7);
				
				
				
			}
			else {
				System.out.println("Test failed");
				excelutil.setCellData(file, "Sheet1", i, 7, "Fail");
				excelutil.fillRedColor(file, "Sheet1", i, 7);
				
			}
			
		     Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='CTR PT15']/a[2]")).click();
			
			
		}
		
		
		
		

	}

}
