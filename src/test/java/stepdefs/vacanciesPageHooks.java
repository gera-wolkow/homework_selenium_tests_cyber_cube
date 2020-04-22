package stepdefs;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by iuriiryndin on 21.04.2020
 */
public class vacanciesPageHooks {
    public static SelenideElement menu = $("ul[id=primary-menu]");
    public static ElementsCollection menuButtonsList = menu.$$("li[id^=menu-item-][class^=col]");
    public static SelenideElement navigateButton = $("a[class=button-green]");
    public static SelenideElement searchButton = $("div[class=search-icon]");
    public static SelenideElement pageHeader = $("section[class=page-header]");
    public static SelenideElement pageBody = $("div[class=entry-content]");
    public static ElementsCollection sectionsList = pageBody.$$("h3");

    public static ElementsCollection getVacanciesList (String section) {
        return pageBody.$$("h3").findBy(Condition.text(section)).$$("li[class=lever-job]");
    }

    public static SelenideElement getVacancyTeam (SelenideElement vacancy) {
        return vacancy.$("span[class=lever-job-team]");
    }
}
