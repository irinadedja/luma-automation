package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15L));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getElementBy(By locator) {
        WebElement element = null;

        try {
            waitForElementPresent(locator);
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            System.out.println("Some Error Occured while creating element" + locator.toString());
            e.printStackTrace();
        }

        return element;
    }

    public List<WebElement> getAllElementsBy(By locator) {
        List<WebElement> elements = null;

        try {
            waitForElementPresent(locator);
            elements = driver.findElements(locator);
            return elements;
        } catch (Exception e) {
            System.out.println("Some Error Occured while creating element" + locator.toString());
            e.printStackTrace();
        }

        return elements;
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the element " + locator.toString());
        }
    }

    public void waitForElementVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the element " + element.toString());
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the element " + element.toString());
        }
    }

    public void waitForElementToBeClickable(By element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Some exception occured while waiting for the element " + element.toString());
        }
    }

    public void hooverOnElement(By locator) {
        Actions action = new Actions(driver);
        WebElement element = this.getElementBy(locator);
        action.moveToElement(element).perform();
    }

    public void hooverOnElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
