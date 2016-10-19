package stepDefinition;

import Imaestri.pages.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by syasenovich on 9/21/16.
 */
public class PaginationValidationSteps {

    SitePage sitePage = page(SitePage.class);

    @When("^User clicks (\\d+) page on current page$")
    public void clickPagination(String pageNumber) {
        sitePage.clickPageInPagination(pageNumber);

    }
    @And("Spinner should be displayed")
    public void spinnerShouldBeDisplayedAndClosed()
    {

        sitePage.get("Spinner").isDisplayed();

    }
    @And("^wait until spinner disappears$")
    public void waitUntilSpinnerDisappears()
    {
        sitePage.get("Spinner").waitUntil(Condition.disappears, 30000);
        sleep(1000);
    }

    @Then("check (\\d+) page is opened")
    public void checkPagination(String pageNumber) {
        sitePage.checkPageOpens(pageNumber);

    }
   // @Then("Logged off")


//    @After("TaggedAgain")
//    public void loggedOFF() {
//        sitePage.logOFF();
//
//    }

//
}
