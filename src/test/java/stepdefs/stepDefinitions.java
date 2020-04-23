package stepdefs;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.PendingException;
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

}
