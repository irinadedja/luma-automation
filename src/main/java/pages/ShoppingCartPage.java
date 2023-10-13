package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By cartItems = By.cssSelector(".cart.item");
    private By firstDeleteButton = By.cssSelector("a.action.action-delete");
    private By emptyShoppingCart = By.cssSelector(".cart-empty > p");

    public int getCardItemsNumber() {
        return super.getAllElementsBy(cartItems).size();
    }

    public void removeFirstItem() {
        super.getElementBy(firstDeleteButton).click();
    }

    public String getEmptyShoppingCartMessage() {

        return super.getElementBy(emptyShoppingCart).getText();
    }
}
