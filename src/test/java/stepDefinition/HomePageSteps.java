package stepDefinition;

import Imaestri.pages.HomePage;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/7/16.
 */
public class HomePageSteps {

    HomePage homePage = page(HomePage.class);

    @Then("check Header for Homepage and open each link")
    public void checkHomepageHeader() {
        homePage.checkHeaderForNotLoggedUser();

    }

    @Then("check Footer for Homepage")
    public void checkHomepageFooter() {
        homePage.checkFooterForNotLoggedUser();

    }
}
