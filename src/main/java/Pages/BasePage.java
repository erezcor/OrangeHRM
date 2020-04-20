package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.CONST.SECONDS_TO_WAIT;
import static org.openqa.selenium.support.PageFactory.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
        protected WebDriver driver;
        protected WebDriverWait wait;

        @FindBy (name = "preview-frame")
        WebElement frame;

        protected BasePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, SECONDS_TO_WAIT);
            initElements(new AjaxElementLocatorFactory(driver, SECONDS_TO_WAIT), this);
        }

        protected void type(WebElement element, String text) {
            //waitToBeVisible(element);
            element.sendKeys(text);
        }

        protected void click(WebElement element) {
            //waitToBeClickable(element);
            element.click();
        }

        public String getCurrentURL() {
            return (driver.getCurrentUrl());
        }

}
