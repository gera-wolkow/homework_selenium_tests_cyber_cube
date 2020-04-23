package stepdefs;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by iuriiryndin on 21.04.2020
 */
public class vacanciesPageHooks {
    public static SelenideElement cookieBanner = $("div[id=hs-eu-cookie-confirmation-inner]");
    public static SelenideElement cookieBannerAcceptButton = $("a[id=hs-eu-confirmation-button]");
    public static SelenideElement logo = $("a[class=logo]");
    public static SelenideElement menu = $("ul[id=primary-menu]");
    public static ElementsCollection menuButtonsList = menu.$$("li[id^=menu-item-][class^=col]");
    public static SelenideElement navigateButton = $("a[class=button-green]");
    public static SelenideElement searchButton = $("div[class=search-icon]");
    public static SelenideElement searchForm = $("input[id=site-search]");
    public static SelenideElement trendsFlag = $("div[class=news-ticker]");
    public static SelenideElement trendsFlagTitle = trendsFlag.$("div[class=ticker-text]");
    public static SelenideElement trendsFlagDownloadButton = trendsFlag.$("a[href]");
    public static SelenideElement pageHeader = $("section[class=page-header]");
    public static SelenideElement pageBody = $("div[class=rf-lever-items-wrapper]");
    public static ElementsCollection sectionsList = pageBody.$$("h3");
    public static ElementsCollection getAllVacanciesList = pageBody.$$("li[class=lever-job]");

    public static ElementsCollection getVacanciesList (String section) {
        return pageBody.$$("h3:contains(" + section + ") ~+ li").filter(Condition.cssClass("lever-job"));

        //h3[text()="Client Services"]/li[following::h3]
    }

    public static SelenideElement getVacancyTeam (SelenideElement vacancy) {
        return vacancy.$("span[class=lever-job-team]");
    }
}
