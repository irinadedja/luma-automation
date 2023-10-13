package test;

import models.RegistrationModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import pages.elements.ProductElement;
import utils.Listeners;

public class LumaTest extends Listeners {

    private RegistrationModel registrationModel;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private StoreMenuPage storeMenuPage;
    private WishListPage wishListPage;
    private ShoppingCartPage shoppingCartPage;
    private ProductPage productPage;


    @Override
    @BeforeTest
    public void beforeTest() {
        this.driver = new ChromeDriver();
        Reporter.log("Auto generated report");
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        this.registrationModel = new RegistrationModel();
        this.homePage = new HomePage(this.driver);
        this.registrationPage = new RegistrationPage(this.driver);
        this.profilePage = new ProfilePage(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.storeMenuPage = new StoreMenuPage(this.driver);
        this.wishListPage = new WishListPage(this.driver);
        this.shoppingCartPage = new ShoppingCartPage(this.driver);
        this.productPage = new ProductPage(this.driver);
    }

    @Test(priority = 1)
    public void createAccount() {
        homePage.clickCreateAccount();

        String pageTitle = registrationPage.getPageTitle();

        Assert.assertEquals(pageTitle, "Create New Customer Account");

        registrationPage.fillRegisterForm(registrationModel);
        registrationPage.clickCreateButton();

        Assert.assertEquals(profilePage.checkSuccessMessageIsDisplayed(), true);
        profilePage.signOut();
    }

    @Test(priority = 2)
    public void loginUser() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickSignIn();
        loginPage.logIn(registrationModel.getEmailAddress(), registrationModel.getPassword());

        // wait for the text to be generated since it is generated with a delay
        Thread.sleep(1500);

        String welcomeText = profilePage.getWelcomeText();
        Assert.assertEquals(welcomeText, "Welcome, " + registrationModel.getFirstName() + " " + registrationModel.getLastName() + "!");

        profilePage.signOut();

    }

    @Test(priority = 3)
    public void checkPageFilters() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickSignIn();

        loginPage.logIn(
                registrationModel.getEmailAddress(),
                registrationModel.getPassword()
        );

        storeMenuPage.goToWomenJacketMenu();
        storeMenuPage.chooseRedColorFilter();

        for (WebElement productWebElement : productPage.getProductsWebElements()) {
            ProductElement productElement = new ProductElement(productWebElement);
            String selectedColor = productElement.getSelectedColor();
            Assert.assertEquals(selectedColor, "Red");
        }


        storeMenuPage.selectRangePriceFilter();
        int productCount = productPage.getProductsWebElements().size();
        Assert.assertEquals(productCount, 2);

        for (WebElement productWebElement : productPage.getProductsWebElements()) {
            ProductElement productElement = new ProductElement(productWebElement);
            int selectedPrice = productElement.getPrice();
            Assert.assertEquals(selectedPrice >= 50 && selectedPrice <= 59, true);
        }

        int productCountBeforeRemoveFilter = productPage.getProductsWebElements().size();
        wishListPage.removePriceFilter();
        int productCountAfterRemoveFilter = productPage.getProductsWebElements().size();
        Assert.assertEquals(productCountAfterRemoveFilter > productCountBeforeRemoveFilter, true);

        wishListPage.chooseFirstItemInWishList();
        Assert.assertEquals(wishListPage.checkSuccessMessageWishListIsDisplayed(), true);
        driver.navigate().to("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?color=58");
//        driver.navigate().back();
        wishListPage.chooseSecondItemInWishList();
        Assert.assertEquals(wishListPage.checkSuccessMessageWishListIsDisplayed(), true);
        driver.navigate().to("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?color=58");

        String myWishListItemsMessage = wishListPage.getMyWishListItemsMessage();
        Assert.assertEquals(myWishListItemsMessage, "My Wish List 2 items");


        for (WebElement productWebElement : productPage.getProductsWebElements()) {
            ProductElement productElement = new ProductElement(productWebElement);
            productPage.hooverOnElement(productWebElement);
            productElement.selectMSize();
            productPage.hooverOnElement(productWebElement);
            productElement.addToCart();
        }

        Thread.sleep(2000);

        Assert.assertEquals(productPage.checkSuccessMessageShoppingCartIsDisplayed(), true);
        productPage.clickShoppingCartLink();


        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/checkout/cart/");

        int initialNumberItems = shoppingCartPage.getCardItemsNumber();

        for (int i = 1; i <= initialNumberItems; i++) {
            shoppingCartPage.removeFirstItem();
            int currentNumberItems = shoppingCartPage.getCardItemsNumber();
            Assert.assertEquals(currentNumberItems, initialNumberItems - i);
        }

        String emptyMessage = shoppingCartPage.getEmptyShoppingCartMessage();
        Assert.assertEquals(emptyMessage, "You have no items in your shopping cart.");

    }


}
