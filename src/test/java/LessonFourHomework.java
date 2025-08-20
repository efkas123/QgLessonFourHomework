import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LessonFourHomework {
    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; //Used for debug only. CBP
    }

    @Test
    void githubWikiNavigation() {
        open("/");

        //Clicking search field
        $("span.flex-1[data-target='qbsearch-input.inputButtonText']")
                .click();
        //Searching selenide
        $("input#query-builder-test")
                .setValue("selenide").pressEnter();
        //Clicking selenide project
        $("a.prc-Link-Link-85e08")
                .click();
        //Opening selenide Wiki
        $("a[href='https://github.com/search?q=selenide&type=wikis']")
                .click();
        //SoftAssertions test
        $("div.Box-sc-g0xbh4-0.hmwxFk").shouldHave(text("SoftAssertions"));
        //Opening SoftAssertions
        $("a[href='/YuriKopshev/selenide/wiki/SoftAssertions']")
                .click();
        //Opening JUnit Chapter and Switching Tabs
        Selenide.Wait().until(driver -> driver.getWindowHandles().size() > 1);
        switchTo().window(1);
        //JUnit5 assertion
        $("div.markdown-body")
                .shouldHave(text("JUnit5 extension"));
    }
}


