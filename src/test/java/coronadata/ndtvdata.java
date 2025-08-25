package coronadata;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ndtvdata {

    public List<String> Ndtv() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ndtv.com/coronavirus");
        Thread.sleep(15000);

        // Switch to iframe containing the data table
        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"tab-1\"]/iframe"));
        driver.switchTo().frame(iframeElement);

        // Locate the table rows
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        List<String> dataList = new ArrayList<>();

        // Iterate through each row and fetch all cell data
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                dataList.add(cell.getText());
            }
        }

        // Close the driver
        driver.quit();

        return dataList;
    }

    // Main method: Entry point of the program
    public static void main(String[] args) throws InterruptedException {
        ndtvdata ndtvDataObj = new ndtvdata();
        List<String> dataList = ndtvDataObj.Ndtv();

        // Print the data list to the console
        for (String data : dataList) {
            System.out.println(data);
        }
    }
}
