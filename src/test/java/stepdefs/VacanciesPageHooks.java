package stepdefs;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by iuriiryndin on 21.04.2020
 */
public class VacanciesPageHooks {
    public static final SelenideElement COOKIE_BANNER = $("div[id=hs-eu-cookie-confirmation-inner]");
    public static final SelenideElement COOKIE_BANNER_ACCEPT_BUTTON = $("a[id=hs-eu-confirmation-button]");
    public static final SelenideElement LOGO = $("a[class=logo]");
    public static final SelenideElement MENU = $("ul[id=primary-menu]");
    public static final ElementsCollection MENU_BUTTONS_LIST = MENU.$$("li[id^=menu-item-][class^=col]");
    public static final SelenideElement NAVIGATE_BUTTON = $("a[class=button-green]");
    public static final SelenideElement SEARCH_BUTTON = $("div[class=search-icon]");
    public static final SelenideElement SEARCH_FORM = $("input[id=site-search]");
    public static final SelenideElement TRENDS_FLAG = $("div[class=news-ticker]");
    public static final SelenideElement TRENDS_FLAG_TITLE = TRENDS_FLAG.$("div[class=ticker-text]");
    public static final SelenideElement TRENDS_FLAG_DOWNLOAD_BUTTON = TRENDS_FLAG.$("a[href]");
    public static final SelenideElement PAGE_HEADER = $("section[class=page-header]");
    public static final SelenideElement FILTER = $("div[class=rf-lever-filters]");
    public static final SelenideElement FILTER_LOCATION_TITLE = FILTER.$("label[for=filter-location]");
    public static final SelenideElement FILTER_LOCATION_INPUT = FILTER.$("select[id=filter-location]");
    public static final SelenideElement FILTER_TEAM_TITLE = FILTER.$("label[for=filter-team]");
    public static final SelenideElement FILTER_TEAM_INPUT = FILTER.$("select[id=filter-team]");
    public static final SelenideElement EMPTY_WARNING = $("div[class=rf-lever-empty]");
    public static final SelenideElement PAGE_BODY = $("div[class=rf-lever-items-wrapper]");
    public static final ElementsCollection SECTIONS_LIST = PAGE_BODY.$$("h3");
    public static final ElementsCollection GET_ALL_VACANCIES_LIST = PAGE_BODY.$$("li[class=lever-job]");
    public static final SelenideElement FOOTER = $("div[class=footer-cta]");
    public static final SelenideElement FOOTER_TITLE = FOOTER.$("h3");
    public static final SelenideElement FOOTER_BUTTON = FOOTER.$("a[class=button-green]");

    public static SelenideElement getSubMenuByButton (String buttonName) {
        return MENU_BUTTONS_LIST.findBy(Condition.text(buttonName)).$("ul[class=sub-menu]");
    }

    public static ElementsCollection getVacancyBySection (String section) {
        return SECTIONS_LIST.findBy(Condition.text(section)).$x("following-sibling::ul").$$("li[class=lever-job]");
    }

    public static SelenideElement getVacancyLocation (SelenideElement vacancy) {
        return vacancy.$("span[class^=lever-job-location]");
    }

    public static SelenideElement getVacancyTeam (SelenideElement vacancy) {
        return vacancy.$("span[class=lever-job-team]");
    }
}
