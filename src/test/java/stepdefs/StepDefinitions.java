package stepdefs;

import com.codeborne.selenide.Condition;
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
public class StepDefinitions extends VacanciesPageHooks {


    @Given("^Visitor is on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void visitorIsOnThePageOnURL(String title, String url) {
        open(url);
        if (COOKIE_BANNER.isDisplayed()) {
            COOKIE_BANNER_ACCEPT_BUTTON.click();
        }
        Assert.assertEquals(title(), title);
    }

    @Then("^Visitor should see \"([^\"]*)\" buttons$")
    public void visitorShouldSeeMenuListButtons(List<String> menu) {
        Assert.assertEquals(MENU_BUTTONS_LIST.size(), menu.size());
        int i = 0;
        while (i < menu.size()) {
            Assert.assertEquals(MENU_BUTTONS_LIST.get(i).text(), menu.get(i));
            i++;
        }
    }

    @Then("^Visitor should see \"([^\"]*)\" navigate button$")
    public void visitorShouldSeeNavigateButton(String buttonText) {
        Assert.assertTrue(NAVIGATE_BUTTON.isDisplayed());
        Assert.assertEquals(NAVIGATE_BUTTON.text(), buttonText);
    }

    @Then("^Visitor should see Search button$")
    public void visitorShouldSeeSearchButton() {
        Assert.assertTrue(SEARCH_BUTTON.isDisplayed());
    }

    @Then("^Visitor should see \"([^\"]*)\" text topic$")
    public void visitorShouldSeeText(String headerText) {
        Assert.assertEquals(PAGE_HEADER.getText(), headerText);
    }

    @Then("^Visitor should see \"([^\"]*)\" section$")
    public void visitorShouldSeeListOfSectionsSection(List<String> sections) {
        Assert.assertEquals(SECTIONS_LIST.size(), sections.size());
        int i = 0;
        while (i < sections.size()) {
            Assert.assertEquals(SECTIONS_LIST.get(i).text(), sections.get(i));
            i++;
        }
    }

    @When("^Visitor clicks on \"Request More Information\" navigate button$")
    public void visitorClicksOnNavigateButton(){
        Assert.assertTrue(NAVIGATE_BUTTON.isDisplayed());
        NAVIGATE_BUTTON.click();
    }

    @Then("^Visitor navigates to URL \"([^\"]*)\"$")
    public void visitorNavigatesToURL(String url) {
        Assert.assertEquals(url(), url);
    }

    @When("^Visitor clicks on Search button$")
    public void visitorClicksOnSearchButton() {
        Assert.assertTrue(SEARCH_BUTTON.isDisplayed());
        SEARCH_BUTTON.click();
    }

    @Then("^Search form appears$")
    public void searchFormAppears() {
        Assert.assertTrue(SEARCH_FORM.isDisplayed());
    }

    @Then("^Visitor should see Logo$")
    public void visitorShouldSeeLogo() {
        Assert.assertTrue(LOGO.isDisplayed());
    }

    @When("^Visitor clicks on Logo$")
    public void visitorClicksOnLogo() {
        Assert.assertTrue(LOGO.isDisplayed());
        LOGO.click();
    }

    @And("^Visitor should see Trends Title with \"([^\"]*)\" text$")
    public void visitorShouldSeeTrendsTitleWithText(String text)  {
        Assert.assertTrue(TRENDS_FLAG_TITLE.isDisplayed());
        Assert.assertEquals(TRENDS_FLAG_TITLE.text(), text);
    }

    @Then("^Visitor should see Trends Flag$")
    public void visitorShouldSeeTrendsFlag() {
        Assert.assertTrue(TRENDS_FLAG.isDisplayed());
    }

    @And("^Visitor should see Trends Download Button with \"([^\"]*)\" text$")
    public void visitorShouldSeeTrendsDownloadButtonWithText(String text) {
        Assert.assertTrue(TRENDS_FLAG_DOWNLOAD_BUTTON.isDisplayed());
        Assert.assertEquals(TRENDS_FLAG_DOWNLOAD_BUTTON.text(), text);
    }

    @When("^Visitor clicks on Trends Download Button$")
    public void visitorClicksOnTrendsDownloadButton() {
        Assert.assertTrue(TRENDS_FLAG_DOWNLOAD_BUTTON.isDisplayed());
        TRENDS_FLAG_DOWNLOAD_BUTTON.click();
    }

    @Then("^Visitor navigates to URL \"([^\"]*)\" in new tab$")
    public void visitorNavigatesToURLInNewTab(String url) {
        switchTo().window(1);
        Assert.assertEquals(url(), url);
        closeWindow();
    }

    @Then("^Visitor should see \"([^\"]*)\" filter title and \"([^\"]*)\" filter title$")
    public void visitorShouldSeeFilterTitleAndFilterTitle(String location, String team) {
        Assert.assertTrue(FILTER_LOCATION_TITLE.isDisplayed());
        Assert.assertEquals(FILTER_LOCATION_TITLE.text(), location);
        Assert.assertTrue(FILTER_TEAM_TITLE.isDisplayed());
        Assert.assertEquals(FILTER_TEAM_TITLE.text(), team);
    }

    @Then("^Visitor should see Location drop-down and Team drop-down$")
    public void visitorShouldSeeLocationDropDownAndTeamDropDown() {
        Assert.assertTrue(FILTER_LOCATION_INPUT.isDisplayed());
        Assert.assertTrue(FILTER_TEAM_INPUT.isDisplayed());
    }

    @When("^Visitor select \"([^\"]*)\" in Location drop-down$")
    public void visitorSelectInLocationDropDown(String option) {
        FILTER_LOCATION_INPUT.selectOption(option);
    }

    @Then("^Visitor should see vacancies list with \"([^\"]*)\" locations or text \"([^\"]*)\"$")
    public void visitorShouldSeeVacanciesListWithLocations(String option, String warning) {
        ElementsCollection list = GET_ALL_VACANCIES_LIST;
        if (list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                Assert.assertEquals(getVacancyLocation(list.get(i)).text(), option);
                i++;
            }
        } else {
            Assert.assertEquals(EMPTY_WARNING.text(), warning);
        }
    }

    @When("^Visitor select \"([^\"]*)\" in Team drop-down$")
    public void visitorSelectInTeamDropDown(String option)  {
        FILTER_TEAM_INPUT.selectOption(option);
    }


    @Then("^Visitor should see vacancies list with \"([^\"]*)\" teams or text \"([^\"]*)\"$")
    public void visitorShouldSeeVacanciesListWithTeamsOrText(String option, String warning) {
        ElementsCollection list = GET_ALL_VACANCIES_LIST;
        if (list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                Assert.assertEquals(getVacancyTeam(list.get(i)).text(), option);
                i++;
            }
        } else {
            Assert.assertEquals(EMPTY_WARNING.text(), warning);
        }
    }

    @Then("^Every vacancy should have \"([^\"]*)\" team corresponding to section$")
    public void everyVacancyShouldHaveTeamCorrespondingToSection(String option) {
        ElementsCollection list = getVacancyBySection(option);
        int i = 0;
        while (i < list.size()) {
            Assert.assertEquals(getVacancyTeam(list.get(i)).text(), option);
            i++;
        }
    }

    @Then("^Visitor should see footer with title \"([^\"]*)\"$")
    public void visitorShouldSeeFooterWithTitle(String title) {
        Assert.assertTrue(FOOTER_TITLE.isDisplayed());
        Assert.assertEquals(FOOTER_TITLE.getText(), title);
    }

    @Then("^Visitor should see \"([^\"]*)\" footer button$")
    public void visitorShouldSeeFooterButton(String text){
        Assert.assertTrue(FOOTER_BUTTON.isDisplayed());
        Assert.assertEquals(FOOTER_BUTTON.text(), text);
    }

    @When("^Visitor clicks on \"Contact a CyberCube expert\" footer button$")
    public void visitorClicksOnFooterButton() {
        Assert.assertTrue(FOOTER_BUTTON.isDisplayed());
        FOOTER_BUTTON.click();
    }

    @When("^Visitor hovers \"([^\"]*)\" buttons$")
    public void visitorHoversButtons(String buttonName) {
        MENU_BUTTONS_LIST.findBy(Condition.text(buttonName)).hover();
    }

    @Then("^Sub-menu \"([^\"]*)\" appears$")
    public void subMenuAppears(String buttonName) {
        Assert.assertTrue(getSubMenuByButton(buttonName).isDisplayed());
    }
}
