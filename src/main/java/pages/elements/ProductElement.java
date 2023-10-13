package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class ProductElement {
    private WebElement product;

    public ProductElement(WebElement product) {
        this.product = product;
    }

    // Selectoret
    private By nameSelector = By.cssSelector(".product.name.product-item-name > a");
    private By priceSelector = By.cssSelector(".price-wrapper");


    private By selectedColorSelector = By.cssSelector(".swatch-option.color.selected");

    private By sizeMSelector = By.id("option-label-size-143-item-168");
    private By addToCartSelector = By.cssSelector(".product-item-inner button");

    // veprimet
    public String getTitle() {
        return product.findElement(nameSelector).getText();
    }

    public int getPrice() {
        String priceStringified = product.findElement(priceSelector).getAttribute("data-price-amount");
        return Integer.parseInt(priceStringified);
    }

    public String getSelectedColor() {
        return product.findElement(selectedColorSelector).getAttribute("option-label");
    }

    public void selectMSize() {
        product.findElement(sizeMSelector).click();
    }

    public void addToCart() {
        product.findElement(addToCartSelector).click();
    }
}
