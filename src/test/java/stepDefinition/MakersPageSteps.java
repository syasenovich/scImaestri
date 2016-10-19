package stepDefinition;

import Imaestri.pages.MakersPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import java.awt.*;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 9/28/16.
 */
public class MakersPageSteps {

    MakersPage makersPage = page(MakersPage.class);

    @Then("open All Makers detail pages and check page is opened and product titles are displayed")
    public void openAllMakersDetailsPageAndCheckProductTitles() throws InterruptedException, AWTException {
        Assert.assertEquals("Some issues on the pages: " + makersPage.openAllMakersPages(false), "");

    }

    @When("check that All Makers detail pages opens")
    public void openAllMakersDetailsPage() throws InterruptedException, AWTException {
        Assert.assertEquals("Some issues on the pages: " + makersPage.openAllMakersPages(true), "");

    }
}
