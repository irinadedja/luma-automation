package pages;

import models.RegistrationModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameSelector = By.id("firstname");
    private By lastNameSelector = By.id("lastname");
    private By emailSelector = By.id("email_address");
    private By passwordSelector = By.id("password");
    private By confirmPasswordSelector = By.id("password-confirmation");
    private By createAccountButtonSelector = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
    private By passwordErrorSelector = By.id("password-error");

    public WebElement getCreateAccountElement() {
        return super.getElementBy(createAccountButtonSelector);
    }

    public String getPasswordErrorString() {
        return super.getElementBy(passwordErrorSelector).getText();
    }

    public void fillRegisterForm(RegistrationModel registrationModel) {
        //getNameElement().sendKeys(registrationModel.getName());
        super.getElementBy(firstNameSelector).sendKeys(registrationModel.getFirstName());
        super.getElementBy(lastNameSelector).sendKeys(registrationModel.getLastName());
        super.getElementBy(emailSelector).sendKeys(registrationModel.getEmailAddress());
        super.getElementBy(passwordSelector).sendKeys(registrationModel.getPassword());
        super.getElementBy(confirmPasswordSelector).sendKeys(registrationModel.getConfirmPassword());
    }

    public void clickCreateButton() {
        super.getElementBy(createAccountButtonSelector).click();
    }

}
