package tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "allure-framework/allure2";
    private static final int ISSUE_NUMBER = 1270;

    private WebSteps webSteps = new WebSteps();

    @Test
    public void annotatedStepsSearchIssue() {
        webSteps.openPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.openRepository(REPOSITORY);
        webSteps.openIssue();
        webSteps.shouldExistIssueWithNumber(ISSUE_NUMBER);
    }
}
