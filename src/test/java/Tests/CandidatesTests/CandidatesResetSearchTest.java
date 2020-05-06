package Tests.CandidatesTests;

import Pages.rightMenuFramePages.CandidatesPage;
import Tests.BaseTest;
import org.junit.Test;

import static Processes.Utils.goToCandidatesPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CandidatesResetSearchTest extends BaseTest {
    String SELECT_DEFAULT_VALUE_TEXT = "All";

    String startDate = "2020-01-01";
    String endDate = "2019-05-01";
    String candidateName = "";
    String methodOfApplication = "Online";
    String applicationStatus = "Hired";

    @Test
    public void candidatesResetSearchTest() {
        goToCandidatesPage(driver);

        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.searchCandidate(candidateName, methodOfApplication, applicationStatus, startDate, endDate);
        candidatesPage.resetSearch();

        assertThat(candidatesPage.getApplicationStatusText(), is(SELECT_DEFAULT_VALUE_TEXT));
        assertThat(candidatesPage.getMethodOfApplicationText(), is(SELECT_DEFAULT_VALUE_TEXT));
    }
}
