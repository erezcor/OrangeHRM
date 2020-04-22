package Tests.NegativeTests.OrganizationInfoNegativeTests;

import Entities.Organization;
import Pages.rightMenuFramePages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.INVALID_NUMBER_ERROR;
import static Entities.Organization.anOrganizationDetails;
import static Processes.Utils.goToOrganizationInfoPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrganizationInfoWithInvalidPhone extends BaseTest {
    final String INVALID_PHONE_NUMBER = "InvalidPhoneNumber123";
    final String INVALID_PHONE_NUMBER_ERROR = INVALID_NUMBER_ERROR;
    Organization organization = anOrganizationDetails().phoneNumber(INVALID_PHONE_NUMBER).build();

    @Test
    public void addOrganizationInfoWithInvalidPhoneTest() {
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.replaceInfoDetailsWith(organization);

        assertThat(organizationInfoPage.getPhoneErrorMessageText(), is(INVALID_PHONE_NUMBER_ERROR));
    }
}
