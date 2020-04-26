package Pages.rightMenuFramePages;

import Entities.Organization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OrganizationInfoPage extends rightMenuFramePage {
    final String SUCCESS_MESSAGE_SELECTOR = "#messagebar > span";
    final String INVALID_EMAIL_ERROR_SELECTOR = "#frmGenInfo > div:nth-child(10) > label > label";
    final String INVALID_PHONE_ERROR_SELECTOR = "#frmGenInfo > div:nth-child(9) > label:nth-child(1) > label";
    final String INVALID_FAX_ERROR_SELECTOR = "#frmGenInfo > div:nth-child(9) > label:nth-child(4) > label";

    @FindBy (id = "organization_name")
    WebElement organizationName;

    @FindBy (id = "organization_phone")
    WebElement organizationPhoneNumber;

    @FindBy (id = "organization_fax")
    WebElement organizationFaxNumber;

    @FindBy (id = "organization_email")
    WebElement organizationEmail;

    @FindBy (id = "btnSaveGenInfo")
    WebElement editButton;

    @FindBy (id = "btnSaveGenInfo")
    WebElement saveButton;

    @FindBy (css = SUCCESS_MESSAGE_SELECTOR)
    WebElement successMessage;

    @FindBy (className = "error")
    WebElement noOrganizationNameError;

    @FindBy (css = INVALID_EMAIL_ERROR_SELECTOR)
    WebElement invalidEmailError;

    @FindBy (css = INVALID_PHONE_ERROR_SELECTOR)
    WebElement invalidPhoneError;

    @FindBy (css = INVALID_FAX_ERROR_SELECTOR)
    WebElement invalidFaxError;

    public OrganizationInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getNoOrganizationNameErrorMessageText() {
        return (this.noOrganizationNameError.getText());
    }

    public String getPhoneErrorMessageText() {
        return (this.invalidPhoneError.getText());
    }

    public String getEmailErrorMessageText() {
        return (this.invalidEmailError.getText());
    }

    public String getFaxErrorMessageText() {
        return (this.invalidFaxError.getText());
    }

    public void replaceInfoDetailsWith(Organization organization) {
        this.clearAllFormFields();
        this.fillFormWith(organization);
    }

    private void fillFormWith(String name, String email, String phoneNumber, String faxNumber) {
        this.editButton.click();
        this.organizationName.sendKeys(name);
        this.organizationEmail.sendKeys(email);
        this.organizationPhoneNumber.sendKeys(phoneNumber);
        this.organizationFaxNumber.sendKeys(faxNumber);
        this.saveButton.click();
    }

    private void fillFormWith(Organization organization) {
        fillFormWith(organization.getName(), organization.getEmail(), organization.getPhoneNumber(), organization.getFaxNumber());
    }

    private void clearAllFormFields() {
        this.editButton.click();
        this.organizationName.clear();
        this.organizationEmail.clear();
        this.organizationFaxNumber.clear();
        this.organizationPhoneNumber.clear();
        this.saveButton.click();
    }

    public String getSuccessMessageText() {
        wait.until(visibilityOf(this.successMessage));
        return (this.successMessage.getText());
    }
}
