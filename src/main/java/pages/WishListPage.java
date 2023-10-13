package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    private By removePriceFilterSelector = By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li[1]/a");
    private By firstItemSelector = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");
    private By firstItemInWishListSelector = By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");
    private By secondItemSelector = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span/img");
    private By secondItemInWishListSelector = By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");

    private By successMessageWishListTextSelector = By.xpath("//*[@data-ui-id=\"message-success\"]/div");
    private By succesMessageWishListContainerSelector = By.xpath("//*[@data-ui-id=\"message-success\"]");
    private By myWishListTextSelector = By.cssSelector(".block-wishlist .block-title strong");
    private By myWishListItemsTextSelector = By.cssSelector(".block-wishlist .block-title .counter");
    private By hereSelector = By.xpath("//*[@data-ui-id=\"message-success\"]/div/a");


    public void removePriceFilter() {
        super.getElementBy(removePriceFilterSelector).click();
    }

    public void chooseFirstItemInWishList() {
        super.getElementBy(firstItemSelector).click();
        super.getElementBy(firstItemInWishListSelector).click();
//        driver.navigate().to("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?color=58");
    }

    public void chooseSecondItemInWishList() {
        super.getElementBy(secondItemSelector).click();
        super.getElementBy(secondItemInWishListSelector).click();
//        driver.navigate().to("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?color=58");
    }

    public String getMyWishListItemsMessage() {
        String myWishListText = super.getElementBy(myWishListTextSelector).getText();
        String myWishListItemsText = super.getElementBy(myWishListItemsTextSelector).getText();

        return myWishListText + " " + myWishListItemsText;
    }

    public boolean checkSuccessMessageWishListIsDisplayed() {
        WebElement successMessageContainerEl = super.getElementBy(succesMessageWishListContainerSelector);
        boolean successIconIsPresent = successMessageContainerEl.getAttribute("class").contentEquals("message-success success message");


        WebElement successMessageElement = super.getElementBy(successMessageWishListTextSelector);
        return successMessageElement.isDisplayed() && successIconIsPresent;
    }

}
