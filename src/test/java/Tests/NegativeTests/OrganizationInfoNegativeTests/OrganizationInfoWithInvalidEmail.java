package Tests.NegativeTests.OrganizationInfoNegativeTests;

import Entities.Organization;
import Pages.rightMenuFramePages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.INVALID_EMAIL_ERROR;
import static Entities.Organization.anOrganizationDetails;
import static Processes.Utils.goToOrganizationInfoPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrganizationInfoWithInvalidEmail extends BaseTest {
    final String INVALID_EMAIL = "invalidEmailFormat";
    final String INVALID_ORGANIZATION_EMAIL_ERROR = INVALID_EMAIL_ERROR;

    Organization organizationInfo = anOrganizationDetails().email(INVALID_EMAIL).build();

    @Test
    public void organizationInfoWithWrongEmailTest() {
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.replaceInfoDetailsWith(organizationInfo);

        assertThat(organizationInfoPage.getEmailErrorMessageText(), is(INVALID_ORGANIZATION_EMAIL_ERROR));
    }
}
