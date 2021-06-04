package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "allure-framework/allure2";
    private static final int ISSUE_NUMBER = 1270;

    @Test
    public void lambdaIssueSearch() {
        step("Open main page", (s) -> {
            s.parameter("Url", BASE_URL);
            open(BASE_URL);
        });

        step("Search for repository " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Move to repository " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText(REPOSITORY)).click();
        });

        step("Open tab issue in repository", () -> {
            $(withText("Issues")).click();
        });

        step("Issue with number " + ISSUE_NUMBER + " exists", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            $(withText("#1270")).shouldBe(visible);
        });
    }
}