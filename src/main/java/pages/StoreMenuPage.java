package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StoreMenuPage extends BasePage {
    public StoreMenuPage(WebDriver driver) {
        super(driver);
    }

    private By womenDropdownSelector = By.cssSelector("#ui-id-2 .nav-2");
    private By topsDropdownSelector = By.id("ui-id-9");
    private By jacketWomenSelector = By.id("ui-id-11");
    private By colorDropdownSelector = By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[1]");
    private By redColorSelector = By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/div/div/a[8]/div");
    private By priceDropdownSelector = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[1]");
    private By rangePriceSelector = By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[1]");
    private By twoProductDisplayedSelector = By.id("toolbar-amount");

    public void goToWomenJacketMenu() {
        super.hooverOnElement(womenDropdownSelector);
        super.hooverOnElement(topsDropdownSelector);
        super.hooverOnElement(jacketWomenSelector);

        super.getElementBy(jacketWomenSelector).click();
    }

    public void chooseRedColorFilter() {
        super.getElementBy(colorDropdownSelector).click();
        super.getElementBy(redColorSelector).click();
    }

    public void selectRangePriceFilter() {
        super.getElementBy(priceDropdownSelector).click();
        super.getElementBy(rangePriceSelector).click();
    }

}
