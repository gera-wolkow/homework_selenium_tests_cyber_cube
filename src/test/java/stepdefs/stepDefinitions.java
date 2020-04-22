package stepdefs;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by iuriiryndin on 22.04.2020
 */
public class stepDefinitions extends vacanciesPageHooks{


    @Given("^Visitor is on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void visitorIsOnThePageOnURL(String title, String url) {
        open(url);
        Assert.assertEquals(title(), title);
    }

    @Then("^Visitor should see \"([^\"]*)\" buttons$")
    public void visitorShouldSeeMenuListButtons(List<String> menu) {
        System.out.println(menu.toString());
        Assert.assertEquals(menuButtonsList.size(), menu.size());
        int i = 0;
        while (i < menu.size()) {
            Assert.assertEquals(menuButtonsList.get(i).text(), menu.get(i));
            i++;
        }
    }

    @Then("^Visitor should see \"([^\"]*)\" navigate button$")
    public void visitorShouldSeeNavigateButton(String buttonText) {
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

    @Then("^Every element in \"([^\"]*)\" should have \"([^\"]*)\" team attribute$")
    public void everyElementInShouldHaveTeamAttribute(String section, String attribute) {
        ElementsCollection vacanciesList = getVacanciesList(section);
        int i = 0;
        while (i < vacanciesList.size()) {
            Assert.assertEquals(getVacancyTeam(vacanciesList.get(i)).text(), attribute);
            i++;
        }
    }
}
