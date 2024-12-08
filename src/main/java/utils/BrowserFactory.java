package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver startBrowser(String url) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Running tests in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU for better performance
        options.addArguments("--window-size=1920x1080"); // Set the window size for headless mode

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set the path for ChromeDriver

        driver = new ChromeDriver(options);
        driver.get(" http://demo.guru99.com/test/newtours/");
        Thread.sleep(10000);
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
