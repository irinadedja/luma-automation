package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By createAccountSelector = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");

    private By signInSelector = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");

    public void clickCreateAccount() {
        super.getElementBy(createAccountSelector).click();
    }

    public void clickSignIn() {
        super.getElementBy(signInSelector).click();
    }
}
