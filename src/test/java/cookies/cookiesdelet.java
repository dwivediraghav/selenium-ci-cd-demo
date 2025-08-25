package cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class cookiesdelet{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mygov.in/");

        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        // Print each cookie's details
        for (Cookie cookie : cookies) {
            System.out.println("Name  : " + cookie.getName());
            System.out.println("Value : " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path  : " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Secure: " + cookie.isSecure());
            System.out.println("--------------------------------");
        }

        driver.quit();
    }
}
