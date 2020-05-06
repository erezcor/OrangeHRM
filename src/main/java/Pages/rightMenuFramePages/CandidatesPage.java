package Pages.rightMenuFramePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CandidatesPage extends rightMenuFramePage {
    @FindBy (id = "candidateSearch_candidateName")
    WebElement candidateNameForSearch;

    @FindBy (id = "candidateSearch_modeOfApplication")
    WebElement methodOfApplicationForSearch;

    @FindBy (id = "candidateSearch_status")
    WebElement applicationStatusForSearch;

    @FindBy (id = "candidateSearch_fromDate")
    WebElement startingDateOfApplicationSearch;

    @FindBy (id = "candidateSearch_toDate")
    WebElement endingDateOfApplicationSearch;

    @FindBy (id = "btnSrch")
    WebElement searchButton;

    @FindBy (id = "btnRst")
    WebElement resetSearchButton;

    public CandidatesPage(WebDriver driver) {
        super(driver);
    }

    public void searchCandidate(String candidateName, String methodOfApplication, String applicationStatus,
                           String startDate, String endingDate) {
        candidateNameForSearch.sendKeys(candidateName);
        getMethodOfApplicationSelect().selectByVisibleText(methodOfApplication);
        getApplicationStatusSelect().selectByVisibleText(applicationStatus);

        startingDateOfApplicationSearch.clear();
        startingDateOfApplicationSearch.sendKeys(startDate);
        endingDateOfApplicationSearch.clear();
        endingDateOfApplicationSearch.sendKeys(endingDate);

        this.searchButton.click();
    }

    public void resetSearch() {
        resetSearchButton.click();
    }

    public String getCandidateNameText() {
        return candidateNameForSearch.getText();
    }

    public String getMethodOfApplicationText() {
        return getMethodOfApplicationSelect().getFirstSelectedOption().getText();
    }

    public String getApplicationStatusText() {
        return getApplicationStatusSelect().getFirstSelectedOption().getText();
    }

    private Select getMethodOfApplicationSelect() {
        return getSelect(methodOfApplicationForSearch);
    }

    private Select getApplicationStatusSelect() {
        return getSelect(applicationStatusForSearch);
    }
}
