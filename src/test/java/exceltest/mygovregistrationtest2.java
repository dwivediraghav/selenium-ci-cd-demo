package exceltest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mygovregistrationtest2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        
        String file = System.getProperty("user.dir") + "\\testdata\\mygovregistrations.xlsx";
        int row = excelutil.getRowCount(file, "Sheet1");

        
        for (int i = 1; i <= row; i++) {
            driver.get("https://demoauth.mygov.in/user/login");
            driver.findElement(By.xpath("//div[@id='bottom_part']//div/span[2]")).click();
            Thread.sleep(3000);

            
            String name = excelutil.getCellData(file, "Sheet1", i, 0);
            String email = excelutil.getCellData(file, "Sheet1", i, 1);
            String country = excelutil.getCellData(file, "Sheet1", i, 2);
            String mobno = excelutil.getCellData(file, "Sheet1", i, 3);
            String day = excelutil.getCellData(file, "Sheet1", i, 4);
            String month = excelutil.getCellData(file, "Sheet1", i, 5);
            String year = excelutil.getCellData(file, "Sheet1", i, 6);
            String gender = excelutil.getCellData(file, "Sheet1", i, 7);
            String refer1 = excelutil.getCellData(file, "Sheet1", i, 8);
            String otp = excelutil.getCellData(file, "Sheet1", i, 9);
            

            String result = "";

            
            if (!name.isEmpty()) {
                driver.findElement(By.id("edit-full-name")).sendKeys(name);
            } else {
                excelutil.setCellData(file, "Sheet1", i, 10, "Fail - Missing Name");
                excelutil.fillRedColor(file, "Sheet1", i, 10);
                continue; 
            }

           
            if (!email.isEmpty()) {
                driver.findElement(By.id("edit-email")).sendKeys(email);
            }

            
            if (!country.isEmpty()) {
                WebElement staticDropdown = driver.findElement(By.id("edit-gateway-country"));
                Select dropdown = new Select(staticDropdown);
                dropdown.selectByVisibleText(country);
            }

            
            if (!mobno.isEmpty()) {
                driver.findElement(By.id("edit-number")).sendKeys(mobno);
            }

            
            if (mobno.isEmpty() && email.isEmpty()) {
                excelutil.setCellData(file, "Sheet1", i, 10, "Fail - Email and Mobile number missing");
                excelutil.fillRedColor(file, "Sheet1", i, 10);
                continue; 
            }

            
          /*  if (!day.isEmpty()) {
                WebElement staticDate = driver.findElement(By.id("edit-links-fieldset-date"));
                Select date = new Select(staticDate);
                date.selectByVisibleText(day);
            }*/
            
            
         // Validate the day before selection
            if (!day.isEmpty()) {
                try {
                    int dayValue = Integer.parseInt(day);
                    if (dayValue >= 1 && dayValue <= 31) {
                        WebElement staticDate = driver.findElement(By.id("edit-links-fieldset-date"));
                        Select date = new Select(staticDate);
                        date.selectByVisibleText(day);
                    } else {
                        // Log the invalid day in the Excel sheet
                        excelutil.setCellData(file, "Sheet1", i, 10, "Fail - Invalid day: " + day);
                        excelutil.fillRedColor(file, "Sheet1", i, 10);
                        continue; // Skip the rest of the iteration for this row
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the day value is not a number
                    excelutil.setCellData(file, "Sheet1", i, 10, "Fail - Day is not a number");
                    excelutil.fillRedColor(file, "Sheet1", i, 10);
                    continue;
                }
            }


            if (!month.isEmpty()) {
                WebElement staticMonth = driver.findElement(By.id("edit-links-fieldset-month"));
                Select months = new Select(staticMonth);
                months.selectByVisibleText(month);
            }

            if (!year.isEmpty()) {
                WebElement staticYear = driver.findElement(By.id("edit-links-fieldset-year"));
                Select years = new Select(staticYear);
                years.selectByVisibleText(year);
            }
            

            
            if (!gender.isEmpty()) {
                WebElement staticGender = driver.findElement(By.id("edit-gender"));
                Select gender1 = new Select(staticGender);
                gender1.selectByVisibleText(gender);
            }
            /*if(otp.isEmpty()) {
            	excelutil.setCellData(file, "Sheet1", i, 10, "Otp is missing ");
                excelutil.fillRedColor(file, "Sheet1", i, 10);
            	
            }*/
            	

            
            WebElement ref = driver.findElement(By.id("edit-referal-markup"));
            if (!refer1.isEmpty()) {
                ref.click();
                driver.findElement(By.id("edit-referal-code")).sendKeys(refer1);
            }

            
            driver.findElement(By.id("edit-submit")).click();
            Thread.sleep(3000);

            
            String errorElement = "";
            try {
                errorElement = driver.findElement(By.xpath("//div[@class='messages error']")).getText();
            } catch (Exception e) {
                
                errorElement = "No message found";
            }

            if (errorElement.contains("Error message")) {
                result = "Fail - Error message: " + errorElement;
                excelutil.setCellData(file, "Sheet1", i, 10, result);
                excelutil.fillRedColor(file, "Sheet1", i, 10);

            } 
            else if (otp.isEmpty()) {
            	excelutil.setCellData(file, "Sheet1", i, 10, "Otp is missing ");
                excelutil.fillRedColor(file, "Sheet1", i, 10);
            	
            	
            }
            
            else {
            	driver.findElement(By.id("edit-otp")).sendKeys(otp);
        		driver.findElement(By.id("edit-submit")).click();
        		excelutil.setCellData(file, "Sheet1", i, 10, "You are successfully registered on MyGov ");
                excelutil.fillGreenColor(file, "Sheet1", i, 10);
        		
            }

        }
        driver.quit();
    }
}

