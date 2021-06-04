package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open main page")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Search for repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to repository {repository}")
    public void openRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Open tab 'Issue' in repository")
    public void openIssue() {
        $(withText("Issues")).click();
    }

    @Step("Issue with number {number} exists")
    public void shouldExistIssueWithNumber(int number) {
        $(withText("#" + number)).should(exist);
    }
}
