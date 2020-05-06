package Tests.OrganizationInfoTests;

import Entities.Organization;
import Pages.rightMenuFramePages.OrganizationInfoPage;
import Tests.BaseTest;
import org.junit.Test;

import static Constants.Errors.REQUIRED_FIELD_ERROR;
import static Entities.Organization.anOrganizationDetails;
import static Processes.Utils.goToOrganizationInfoPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrganizationInfoWithNoName extends BaseTest {
    final String BLANK_ORGANIZATION_NAME = "";
    final String REQUIRED_NAME_FIELD_ERROR = REQUIRED_FIELD_ERROR;

    Organization organization = anOrganizationDetails().name(BLANK_ORGANIZATION_NAME).build();

    @Test
    public void addOrganizationInfoWithNoNameTest() {
        goToOrganizationInfoPage(driver);

        OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
        organizationInfoPage.replaceInfoDetailsWith(organization);

        assertThat(organizationInfoPage.getNoOrganizationNameErrorMessageText(), is(REQUIRED_NAME_FIELD_ERROR));
    }
}
