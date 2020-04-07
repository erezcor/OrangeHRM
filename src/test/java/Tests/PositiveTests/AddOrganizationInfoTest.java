package Tests.PositiveTests;

import Pages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;
import static Constants.CONST.*;
import static Processes.Utils.goToOrganizationInfoPage;
import static Processes.Utils.loginAsAdmin;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AddOrganizationInfoTest extends BaseTest {
    final String SAVE_SUCCESS_MESSAGE = "Successfully Saved";
    @BeforeClass

    @Test
    public void AddOrgInfoTest() {
        loginAsAdmin(driver);
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.clearAllFormFields();
        organizationInfoPage.fillFormWith
                            (ORGANIZATION_NAME, ORGANIZATION_EMAIL, ORGANIZATION_PHONE_NUMBER, ORGANIZATION_FAX_NUMBER);

        assertThat(organizationInfoPage.getSuccessMessageText(), containsString(SAVE_SUCCESS_MESSAGE));
    }
}
