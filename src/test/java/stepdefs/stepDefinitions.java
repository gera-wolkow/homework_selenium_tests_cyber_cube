package stepdefs;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by iuriiryndin on 22.04.2020
 */
public class stepDefinitions extends vacanciesPageHooks{


    @Given("^Visitor is on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void visitorIsOnThePageOnURL(String title, String url) {
        open(url);
        if (cookieBanner.isDisplayed()) {
            cookieBannerAcceptButton.click();
        }
        Assert.assertEquals(title(), title);
    }

    @Then("^Visitor should see \"([^\"]*)\" buttons$")
    public void visitorShouldSeeMenuListButtons(List<String> menu) {
        Assert.assertEquals(menuButtonsList.size(), menu.size());
        int i = 0;
        while (i < menu.size()) {
            Assert.assertEquals(menuButtonsList.get(i).text(), menu.get(i));
            i++;
        }
    }

    @Then("^Visitor should see \"([^\"]*)\" navigate button$")
    public void visitorShouldSeeNavigateButton(String buttonText) {
        Assert.assertTrue(navigateButton.isDisplayed());
        Assert.assertEquals(navigateButton.text(), buttonText);
    }

    @Then("^Visitor should see Search button$")
    public void visitorShouldSeeSearchButton() {
        Assert.assertTrue(searchButton.isDisplayed());
    }

    @Then("^Visitor should see \"([^\"]*)\" text topic$")
    public void visitorShouldSeeText(String headerText) {
        Assert.assertEquals(pageHeader.getText(), headerText);
    }

    @Then("^Visitor should see \"([^\"]*)\" section$")
    public void visitorShouldSeeListOfSectionsSection(List<String> sections) {
        Assert.assertEquals(sectionsList.size(), sections.size());
        int i = 0;
        while (i < sections.size()) {
            Assert.assertEquals(sectionsList.get(i).text(), sections.get(i));
            i++;
        }
    }

    @When("^Visitor clicks on \"Request More Information\" navigate button$")
    public void visitorClicksOnNavigateButton(){
        Assert.assertTrue(navigateButton.isDisplayed());
        navigateButton.click();
    }

    @Then("^Visitor navigates to URL \"([^\"]*)\"$")
    public void visitorNavigatesToURL(String url) {
        Assert.assertEquals(url(), url);
    }

    @When("^Visitor clicks on Search button$")
    public void visitorClicksOnSearchButton() {
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
    }

    @Then("^Search form appears$")
    public void searchFormAppears() {
        Assert.assertTrue(searchForm.isDisplayed());
    }

    @Then("^Visitor should see Logo$")
    public void visitorShouldSeeLogo() {
        Assert.assertTrue(logo.isDisplayed());
    }

    @When("^Visitor clicks on Logo$")
    public void visitorClicksOnLogo() {
        Assert.assertTrue(logo.isDisplayed());
        logo.click();
    }

    @And("^Visitor should see Trends Title with \"([^\"]*)\" text$")
    public void visitorShouldSeeTrendsTitleWithText(String text)  {
        Assert.assertTrue(trendsFlagTitle.isDisplayed());
        Assert.assertEquals(trendsFlagTitle.text(), text);
    }

    @Then("^Visitor should see Trends Flag$")
    public void visitorShouldSeeTrendsFlag() {
        Assert.assertTrue(trendsFlag.isDisplayed());
    }

    @And("^Visitor should see Trends Download Button with \"([^\"]*)\" text$")
    public void visitorShouldSeeTrendsDownloadButtonWithText(String text) {
        Assert.assertTrue(trendsFlagDownloadButton.isDisplayed());
        Assert.assertEquals(trendsFlagDownloadButton.text(), text);
    }

    @When("^Visitor clicks on Trends Download Button$")
    public void visitorClicksOnTrendsDownloadButton() {
        Assert.assertTrue(trendsFlagDownloadButton.isDisplayed());
        trendsFlagDownloadButton.click();
    }

    @Then("^Visitor navigates to URL \"([^\"]*)\" in new tab$")
    public void visitorNavigatesToURLInNewTab(String url) {
        switchTo().window(1);
        Assert.assertEquals(url(), url);
        closeWindow();
    }

    @Then("^Visitor should see \"([^\"]*)\" filter title and \"([^\"]*)\" filter title$")
    public void visitorShouldSeeFilterTitleAndFilterTitle(String location, String team) {
        Assert.assertTrue(filterLocationTitle.isDisplayed());
        Assert.assertEquals(filterLocationTitle.text(), location);
        Assert.assertTrue(filterTeamTitle.isDisplayed());
        Assert.assertEquals(filterTeamTitle.text(), team);
    }

    @Then("^Visitor should see Location drop-down and Team drop-down$")
    public void visitorShouldSeeLocationDropDownAndTeamDropDown() {
        Assert.assertTrue(filterLocationInput.isDisplayed());
        Assert.assertTrue(filterTeamInput.isDisplayed());
    }

    @When("^Visitor select \"([^\"]*)\" in Location drop-down$")
    public void visitorSelectInLocationDropDown(String option) {
        filterLocationInput.selectOption(option);
    }

    @Then("^Visitor should see vacancies list with \"([^\"]*)\" locations or text \"([^\"]*)\"$")
    public void visitorShouldSeeVacanciesListWithLocations(String option, String warning) {
        ElementsCollection list = getAllVacanciesList;
        if (list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                Assert.assertEquals(getVacancyLocation(list.get(i)).text(), option);
                i++;
            }
        } else {
            Assert.assertEquals(emptyWarning.text(), warning);
        }
    }

    @When("^Visitor select \"([^\"]*)\" in Team drop-down$")
    public void visitorSelectInTeamDropDown(String option)  {
        filterTeamInput.selectOption(option);
    }


    @Then("^Visitor should see vacancies list with \"([^\"]*)\" teams or text \"([^\"]*)\"$")
    public void visitorShouldSeeVacanciesListWithTeamsOrText(String option, String warning) {
        ElementsCollection list = getAllVacanciesList;
        if (list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                Assert.assertEquals(getVacancyTeam(list.get(i)).text(), option);
                i++;
            }
        } else {
            Assert.assertEquals(emptyWarning.text(), warning);
        }
    }

    @Then("^Every vacancy should have \"([^\"]*)\" team corresponding to section$")
    public void everyVacancyShouldHaveTeamCorrespondingToSection(String option) {
        ElementsCollection list = getVacancyBySection(option);
        System.out.println(list.size());
        int i = 0;
        while (i < list.size()) {
            Assert.assertEquals(getVacancyTeam(list.get(i)).text(), option);
            i++;
        }
    }
}
