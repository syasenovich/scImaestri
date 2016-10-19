package stepDefinition;

import Imaestri.pages.DesignersPage;
import Imaestri.pages.MakersPage;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.awt.*;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/5/16.
 */
public class DesignersPageSteps {

    DesignersPage designersPage = page(DesignersPage.class);

    @Then("check that All Designers detail pages opens")
    public void testAllDesignersPage () throws AWTException, InterruptedException {
        Assert.assertEquals("Some issues on the pages: " + designersPage.openAllDesignersPages(), "");

    }

}
