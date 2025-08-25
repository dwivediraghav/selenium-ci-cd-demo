package exceltest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mygovregistrationtest {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //driver.get("https://demoauth.mygov.in/user/login");
        
        
        String file = System.getProperty("user.dir") + "\\testdata\\mygovregistrationss.xlsx";
        int row = excelutil.getRowCount(file, "Sheet1");

        for (int i = 1; i <= row; i++) {
        	driver.get("https://demoauth.mygov.in/user/login");
        	driver.findElement(By.xpath("//div[@id='bottom_part']//div/span[2]")).click();
            Thread.sleep(3000);


            // Fetching data from Excel file
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
            
            
            
            
            
            
            
            String exp_val = excelutil.getCellData(file, "Sheet1", i, 10);
            
            String result="";

            
            
            if (!name.isEmpty()) { 
            	driver.findElement(By.id("edit-full-name")).sendKeys(name);
            	
            }
            else {
            	
            	excelutil.setCellData(file, "Sheet1", i, 11, "Fail");
                excelutil.fillRedColor(file, "Sheet1", i, 11); 
            }
            
            
            if (!email.isEmpty()) { 
            	driver.findElement(By.id("edit-email")).sendKeys(email);
            }
            
            
            if (!country.isEmpty()) { 
            	WebElement staticDropdown = driver.findElement(By.id("edit-gateway-country"));
                Select dropdown = new Select(staticDropdown);
                dropdown.selectByValue(country);
            }
            
            
            if (!mobno.isEmpty()) { 
            	driver.findElement(By.id("edit-number")).sendKeys(mobno);
            }
            
            if (mobno.isEmpty() && email.isEmpty() ) {
            	excelutil.setCellData(file, "Sheet1", i, 11, "Fail");
                excelutil.fillRedColor(file, "Sheet1", i, 11); 
            	
            }

            

            
            
            
            
            if (!day.isEmpty()) { 
            	WebElement staticDate = driver.findElement(By.id("edit-links-fieldset-date"));
                Select date = new Select(staticDate);
                date.selectByVisibleText(day);
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
                gender1.selectByValue(gender);
            }

            

            
            WebElement ref = driver.findElement(By.id("edit-referal-markup"));

            if (!refer1.isEmpty()) { 
                ref.click(); 
                driver.findElement(By.id("edit-referal-code")).sendKeys(refer1);
            }

            // Submit the form
            driver.findElement(By.id("edit-submit")).click();
            
            Thread.sleep(3000);
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String errorElement="";
            
            try {
             errorElement = driver.findElement(By.xpath("//div[@class='messages error']")).getText();
            }
            catch(Exception e) {
            	
            	errorElement="No message found";
            }
            //if (errorElement != null && !errorElement.contains("No message found")) {
                //String errmsg = errorElement.getText();
                if (errorElement.contains("Error message")) {
                    result = "Fail - Error message: " + errorElement;
                    excelutil.setCellData(file, "Sheet1", i, 11, result);
                    excelutil.fillRedColor(file, "Sheet1", i, 11);}
                
            
                else {
            
            	Thread.sleep(3000);
            	
            	
            	if (!otp.isEmpty()) {
            		driver.findElement(By.id("edit-otp")).sendKeys(otp);
            		driver.findElement(By.id("edit-submit")).click();
                    
                    
            		
            	
            	    
            	Thread.sleep(3000);
            	String otperrorElement="";
            	
            	try {
                    otperrorElement = driver.findElement(By.xpath("//div[@class='messages error']")).getText();
                   }
                   catch(Exception e) {
                   	
                   	
                   }
            	
            		

                   
                    
                        
                        if (otperrorElement.contains("Error message")) {
                            result = "Fail - Error message: " + otperrorElement;
                            excelutil.setCellData(file, "Sheet1", i, 11, result);
                            excelutil.fillRedColor(file, "Sheet1", i, 11);}
                            
                    
            		
            	
                
                
                
                        else {
               
                String actualMessage = "";
                try {
                    
                    actualMessage = driver.findElement(By.xpath("//body/div[@id='auth_box']/div[@id='middle_part']/div[2]")).getText();
                } catch (Exception e) {
                    actualMessage = "No message found";
                }

                
                if (actualMessage.contains(exp_val)) {
                    excelutil.setCellData(file, "Sheet1", i, 11, "Pass");
                    excelutil.fillGreenColor(file, "Sheet1", i, 11); // Highlight as Pass
                } else {
                    excelutil.setCellData(file, "Sheet1", i, 11, "Fail");
                    excelutil.fillRedColor(file, "Sheet1", i, 11);
                    }
                
            

                        }}
            }
        
        }
            /*String errmsg = driver.findElement(By.xpath("//body/div[@id='auth_box']/div[@id='middle_part']/div[2]/h2")).getText();
            if(errmsg.contains("Error message"))
            {
            	excelutil.setCellData(file, "Sheet1", i, 11, "Fail");
                excelutil.fillRedColor(file, "Sheet1", i, 11);
            }*/
            
            
        /*Thread.sleep(3000);
            
            driver.findElement(By.id("edit-otp")).sendKeys(otp);
            
            driver.findElement(By.id("edit-submit")).click();
            
           
            
            String actualMessage = "";
            try {
                // Assuming the message appears in a certain area (you need to confirm the correct element)
                actualMessage = driver.findElement(By.xpath("//body/div[@id='auth_box']/div[@id='middle_part']/div[2]")).getText();
            } catch (Exception e) {
                actualMessage = "No message found";
            }

           
            if (actualMessage.contains(exp_val)) {
                excelutil.setCellData(file, "Sheet1", i, 11, "Pass");
                excelutil.fillGreenColor(file, "Sheet1", i, 11); 
            } else {
                excelutil.setCellData(file, "Sheet1", i, 11, "Fail");
                excelutil.fillRedColor(file, "Sheet1", i, 11);
                }
            
        }

        
        driver.quit();*/
     
        driver.quit();  
    }
}
