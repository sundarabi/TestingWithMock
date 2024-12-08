package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "userName") // Username input field
    WebElement userNameField;

    @FindBy(name = "password") // Password input field
    WebElement passwordField;

    @FindBy(name = "submit") // Submit button
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'invalid')]") // Error message element
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
