package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends BasePage {
    final String WELCOME_TEXT_SELECTOR = "#option-menu > li:nth-child(1)";
    final String ORGANIZATION_MENU_SELECTOR = "#admin > ul > li:nth-child(1) > a";
    final String LOCATION_BUTTON_SELECTOR = "#admin > ul > li:nth-child(1) > ul > li:nth-child(2) > a";
    final String CANDIDATES_BUTTON_SELECTOR = "#recruit > ul > li:nth-child(1) > a";

    @FindBy (id = "admin")
    protected WebElement adminMenu;

    @FindBy (id = "recruit")
    private WebElement recruitmentMenu;

    @FindBy (linkText = "Logout")
    private WebElement logoutButton;

    @FindBy (css = WELCOME_TEXT_SELECTOR)
    private WebElement welcomeText;

    @FindBy (css = ORGANIZATION_MENU_SELECTOR)
    private WebElement organizationSubMenu;

    @FindBy (css = LOCATION_BUTTON_SELECTOR)
    private WebElement locationsPageButton;

    @FindBy (css = CANDIDATES_BUTTON_SELECTOR)
    private WebElement candidatesPageButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeToHomePageText() {
        return (this.welcomeText.getText());
    }

    public void goToLocationsPage() {
        getActionsObject()
                .moveToElement(adminMenu).moveToElement(organizationSubMenu).moveToElement(locationsPageButton).click()
                .build().perform();
    }

    public void goToCandidatesPage() {
        getActionsObject()
                .moveToElement(recruitmentMenu).moveToElement(candidatesPageButton).click()
                .build().perform();
    }

    public void goToOrganizationInfoPage() {
        this.adminMenu.click();
    }
}
