package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BrowserFactory;

public class ECommerceTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        driver = BrowserFactory.startBrowser("http://demo.guru99.com/test/newtours/login.php");
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String validUserName = "tutorial";
        String validPassword = "tutorial";

        loginPage.login(validUserName, validPassword);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);

        // Check if redirected to the home page (successful login)
        Assert.assertTrue(currentUrl.contains("login_success"), "Login failed, URL did not contain 'login_success'");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String invalidUserName = "wronguser";
        String invalidPassword = "wrongpassword";

        loginPage.login(invalidUserName, invalidPassword);

        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Error message displayed: " + errorMessage);

        // Assert the error message
        Assert.assertTrue(errorMessage.contains("Invalid login or password"), "Error message not displayed for invalid login!");
    }

    @AfterMethod
    public void teardown() {
        BrowserFactory.closeBrowser();
    }
}
