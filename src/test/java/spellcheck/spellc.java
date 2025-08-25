package spellcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.openoffice.OpenOfficeSpellDictionary;

public class spellc {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path
        WebDriver driver = new ChromeDriver();

        try {
            // Open the target webpage
            driver.get("https://example.com"); // Replace with your webpage URL

            // Extract visible text
            String pageText = driver.findElement(By.tagName("body")).getText();

            // Initialize the Hunspell dictionary
            File dictionaryFile = new File("path/to/en_US.dic"); // Update with your dictionary file
            File affixFile = new File("path/to/en_US.aff"); // Update with your affix file
            spellc spellChecker = new spellChecker(new OpenOfficeSpellDictionary(dictionaryFile, affixFile));

            // Split the text into words
            String[] words = pageText.split("\\s+");
            List<String> misspelledWords = new ArrayList<>();

            // Check each word
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                if (!word.isEmpty() && !spellChecker.isCorrect(word)) {
                    misspelledWords.add(word);
                }
            }

            // Print the results
            if (misspelledWords.isEmpty()) {
                System.out.println("No spelling mistakes found!");
            } else {
                System.out.println("Misspelled Words:");
                for (String misspelledWord : misspelledWords) {
                    System.out.println("- " + misspelledWord);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
