package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    private WebElement product;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    private By shoppingCartLinkSelector = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/a");

    private By succesMessageShoppingCartContainerSelector = By.xpath("//*[@data-ui-id=\"message-success\"]");

    private By productGridSelector = By.cssSelector(".products-grid .item.product.product-item .product-item-info");

    public List<WebElement> getProductsWebElements() {
        return driver.findElements(productGridSelector);
    }

    public boolean checkSuccessMessageShoppingCartIsDisplayed() {
        WebElement successMessageContainerEl = super.getElementBy(succesMessageShoppingCartContainerSelector);
        boolean successIconIsPresent = successMessageContainerEl.getAttribute("class").contentEquals("message-success success message");
        return successIconIsPresent;
    }

    public void clickShoppingCartLink() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        super.getElementBy(shoppingCartLinkSelector).click();
    }

}
