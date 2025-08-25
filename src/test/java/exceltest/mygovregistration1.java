package exceltest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mygovregistration1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String file = System.getProperty("user.dir") + "\\testdata\\mygov1.xlsx";
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

            String result = "";

            // Fill out the form fields
            if (!name.isEmpty()) {
                driver.findElement(By.id("edit-full-name")).sendKeys(name);
            } else {
                excelutil.setCellData(file, "Sheet1", i, 11, "Fail - Name is empty");
                excelutil.fillRedColor(file, "Sheet1", i, 11);
                continue;
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

            if (mobno.isEmpty() && email.isEmpty()) {
                excelutil.setCellData(file, "Sheet1", i, 11, "Fail - Mobile and email are empty");
                excelutil.fillRedColor(file, "Sheet1", i, 11);
                continue;
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

            // Check if referral checkbox is clicked and enter referral code if provided
            WebElement ref = driver.findElement(By.id("edit-referal-markup"));
            if (!refer1.isEmpty()) {
                ref.click();
                driver.findElement(By.id("edit-referal-code")).sendKeys(refer1);
            }

            // Submit the form
            driver.findElement(By.id("edit-submit")).click();
            Thread.sleep(3000);

            // Error handling and OTP page handling
            try {
                // Check for error message first
                WebElement errorElement = driver.findElement(By.xpath("//div[@class='messages error']"));
                if (errorElement != null) {
                    String errmsg = errorElement.getText();
                    if (errmsg.contains("Error message")) {
                        result = "Fail - Error message: " + errmsg;
                        excelutil.setCellData(file, "Sheet1", i, 11, result);
                        excelutil.fillRedColor(file, "Sheet1", i, 11);
                    }
                }
            } catch (NoSuchElementException e) {
                // If no error, check if OTP page loaded successfully
                try {
                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-otp")));
                    if (otpField != null) {
                        // Enter OTP and submit
                        if (!otp.isEmpty()) {
                            otpField.sendKeys(otp);
                            driver.findElement(By.id("edit-submit")).click();
                            Thread.sleep(3000);

                            // Check the success message
                            
                            String actualMessage="";
                             actualMessage = driver.findElement(By.xpath("//div[@class='success-message']")).getText();
                            if (actualMessage.contains(exp_val)) {
                                excelutil.setCellData(file, "Sheet1", i, 11, "Pass - " + actualMessage);
                                excelutil.fillGreenColor(file, "Sheet1", i, 11);
                            } else {
                                excelutil.setCellData(file, "Sheet1", i, 11, "Fail - Expected message not found");
                                excelutil.fillRedColor(file, "Sheet1", i, 11);
                            }
                        } else {
                            excelutil.setCellData(file, "Sheet1", i, 11, "Fail - OTP is empty");
                            excelutil.fillRedColor(file, "Sheet1", i, 11);
                        }
                    }
                } catch (NoSuchElementException e1) {
                    // Handle case where OTP page did not load
                    
                }
            }
        }

        // Close the browser after test
        driver.quit();
    }
}
