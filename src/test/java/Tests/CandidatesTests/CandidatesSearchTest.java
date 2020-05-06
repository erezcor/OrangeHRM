package Tests.CandidatesTests;

import Pages.rightMenuFramePages.CandidatesPage;
import Tests.BaseTest;
import org.junit.Test;

import static Processes.Utils.goToCandidatesPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CandidatesSearchTest extends BaseTest {
    String startDate = "2020-01-01";
    String endDate = "2019-05-01";
    String candidateName = "";
    String methodOfApplication = "Online";
    String applicationStatus = "Hired";

    @Test
    public void candidateSearchTest() {
        goToCandidatesPage(driver);

        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.searchCandidate(candidateName, methodOfApplication, applicationStatus, startDate, endDate);

        assertThat(candidatesPage.getCandidateNameText(), is(candidateName));
        assertThat(candidatesPage.getMethodOfApplicationText(), is(methodOfApplication));
        assertThat(candidatesPage.getApplicationStatusText(), is(applicationStatus));
    }
}
