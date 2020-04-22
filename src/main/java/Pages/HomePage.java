package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends BasePage {
    final String WELCOME_TEXT_SELECTOR = "#option-menu > li:nth-child(1)";
    final String ORGANIZATION_MENU_SELECTOR = "#admin > ul > li:nth-child(1) > a";
    final String LOCATION_BUTTON_SELECTOR = "#admin > ul > li:nth-child(1) > ul > li:nth-child(2) > a";

    @FindBy (id = "admin")
    protected WebElement adminMenu;

    @FindBy (linkText = "Logout")
    protected WebElement logoutButton;

    @FindBy (css = WELCOME_TEXT_SELECTOR)
    protected WebElement welcomeText;

    @FindBy (css = ORGANIZATION_MENU_SELECTOR)
    protected WebElement organizationMenu;

    @FindBy (css = LOCATION_BUTTON_SELECTOR)
    protected WebElement locationsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeToHomePageText() {
        return (this.welcomeText.getText());
    }

    public void goToLocationsPage() {
        Actions action = new Actions(driver);
        action.moveToElement(this.adminMenu).moveToElement(this.organizationMenu).moveToElement(this.locationsButton).build().perform();
        wait.until(elementToBeClickable(this.locationsButton)).click();
    }

    public void goToOrganizationInfoPage() {
        this.adminMenu.click();
    }
}
