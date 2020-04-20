package Tests.PositiveTests;

import Entities.Organization;
import Pages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.SuccessMessages.SAVE_SUCCESS_MESSAGE;
import static Entities.Organization.anOrganizationDetails;
import static Processes.Utils.goToOrganizationInfoPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddOrganizationInfoTest extends BaseTest {
    final String INFO_SAVE_SUCCESS_MESSAGE = SAVE_SUCCESS_MESSAGE;
    Organization organizationInfo = anOrganizationDetails().build();

    @Test
    public void addOrganizationInfoTest() {
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.replaceInfoDetailsWith(organizationInfo);

        assertThat(organizationInfoPage.getSuccessMessageText(), is(INFO_SAVE_SUCCESS_MESSAGE));
    }
}
