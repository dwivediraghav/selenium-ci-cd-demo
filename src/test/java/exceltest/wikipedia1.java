package exceltest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class wikipedia1 {
    public static void main(String[] args) {
        // File path for the Word document
        String filePath = System.getProperty("user.dir") + "\\testdata\\wikipedia.docx";
        String wordData = null;

        // Reading data from the Word file
        try {
            wordData = readWordFile(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the Word file: " + e.getMessage());
            return; // Exit if file reading fails
        }

        // Selenium WebDriver setup
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the website
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            // Extract data from the website
            By locator = By.id("mp-welcomecount"); // Replace with actual locator
            String webData = getWebData(driver, locator);

            // Compare the data
            String normalizedWordData = normalize(wordData);
            String normalizedWebData = normalize(webData);

            if (!normalizedWordData.equals(normalizedWebData)) {
                System.out.println("Unmatched Content:");

                // Highlight unmatched content in red
                highlightDifferences(wordData, webData);
            } else {
                System.out.println("Data matches perfectly!");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to read text from a Word file
    public static String readWordFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XWPFDocument document = new XWPFDocument(fis);
        StringBuilder fileContent = new StringBuilder();

        document.getParagraphs().forEach(paragraph -> fileContent.append(paragraph.getText()).append("\n"));

        fis.close();
        return fileContent.toString().trim(); // Trim to avoid extra spaces
    }

    // Method to extract data from a webpage using Selenium
    public static String getWebData(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText().trim(); // Trim to ensure clean comparison
    }

    // Method to normalize text for comparison
    public static String normalize(String text) {
        return text.replace("\u00A0", " ")  // Replace non-breaking spaces with regular spaces
                   .replaceAll("\\s+", " ") // Replace multiple spaces/newlines with a single space
                   .replaceAll("\\d{1,3}(,\\d{3})*", "") // Remove dynamic numbers (e.g., 6,911,300)
                   .trim()
                   .toLowerCase(); // Convert to lowercase for case-insensitive comparison
    }

    // Method to highlight differences in red
    public static void highlightDifferences(String wordData, String webData) {
        String[] wordLines = wordData.split("\\n");
        String[] webLines = webData.split("\\n");

        for (int i = 0; i < Math.max(wordLines.length, webLines.length); i++) {
            String wordLine = i < wordLines.length ? wordLines[i] : "";
            String webLine = i < webLines.length ? webLines[i] : "";

            if (!normalize(wordLine).equals(normalize(webLine))) {
                // Print unmatched lines in red
                System.out.println("\u001B[31mFrom Word File: " + wordLine + "\u001B[0m");
                System.out.println("\u001B[31mFrom Website: " + webLine + "\u001B[0m");
            } else {
                // Print matched lines normally
                System.out.println("Matched Line: " + wordLine);
            }
        }
    }
}
