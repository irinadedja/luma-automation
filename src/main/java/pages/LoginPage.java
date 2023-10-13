package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailLogInSelector = By.id("email");
    private By passwordLogInSelector = By.id("pass");
    private By signInButtonSelector = By.id("send2");

    public void logIn(String email, String password) {
        super.getElementBy(emailLogInSelector).sendKeys(email);
        super.getElementBy(passwordLogInSelector).sendKeys(password);
        super.getElementBy(signInButtonSelector).click();
    }
}
