package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By successMessageTextSelector = By.xpath("//*[@data-ui-id=\"message-success\"]/div");
    private By succesMessageContainerSelector = By.xpath("//*[@data-ui-id=\"message-success\"]");
    private By welcomeFullNameSelector = By.cssSelector(".greet.welcome > span.logged-in");

    // private By accountMenuButtonSelector = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private By accountMenuButtonSelector = By.cssSelector(".action.switch");
    private By signOutMenuOptionSelector = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");

    public void signOut() {
        super.getElementBy(accountMenuButtonSelector).click();
        super.getElementBy(signOutMenuOptionSelector).click();
    }

    public boolean checkSuccessMessageIsDisplayed() {

        WebElement successMessageContainerEl = super.getElementBy(succesMessageContainerSelector);
        boolean successIconIsPresent = successMessageContainerEl.getAttribute("class").contentEquals("message-success success message");

        WebElement successMessageElement = super.getElementBy(successMessageTextSelector);
        boolean successMessageIsPresent = successMessageElement.getText().equals("Thank you for registering with Main Website Store.");

        return successMessageIsPresent && successIconIsPresent;
    }

    public String getWelcomeText() {
        WebElement welcomeMessageElement = super.getElementBy(welcomeFullNameSelector);
        return welcomeMessageElement.getText();
    }
}
