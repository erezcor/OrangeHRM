package Tests.OrganizationInfoTests;

import Entities.Organization;
import Pages.rightMenuFramePages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.INVALID_NUMBER_ERROR;
import static Entities.Organization.anOrganizationDetails;
import static Processes.Utils.goToOrganizationInfoPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrganizationInfoWithInvalidFax extends BaseTest {
    String INVALID_FAX_NUMBER = "invalidFaxFormat";
    String INVALID_FAX_NUMBER_ERROR = INVALID_NUMBER_ERROR;
    Organization organization = anOrganizationDetails().faxNumber(INVALID_FAX_NUMBER).build();

    @Test
    public void organizationInfoWithInvalidFaxTest() {
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.replaceInfoDetailsWith(organization);

        assertThat(organizationInfoPage.getFaxErrorMessageText(), is(INVALID_FAX_NUMBER_ERROR));
    }
}
