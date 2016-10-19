package stepDefinition;

import Imaestri.pages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/4/16.
 */
public class RegistrationSteps {
    HomePage homePage = page(HomePage.class);
    SitePage sitePage = page(SitePage.class);
    HomePageLoggedUser homePageLoggedUser = page(HomePageLoggedUser.class);

    RegistrationPage registrationPage = page(RegistrationPage.class);

    private static GetPropertyValues prop;
    private String email;

    public static void readProperties() throws IOException {
        prop = new GetPropertyValues();
        prop.getPropValues();

    }

    @And("^enter valid email and select (.*)  with (\\d+) type and click join us button$")
    public void enterEmailAndTypeAndSubmit(String accountType, int index) throws InterruptedException {

        if (accountType.equals("Consumer"))
            email = prop.CONSUMER_EMAIL;
        else if (accountType.equals("Business"))
            email = prop.BUSINESS_EMAIL;
        else if (accountType.equals("Design Trade"))
            email = prop.DESIGN_TRADE_EMAIL;
        else if (accountType.equals("Consumer Invitations"))
            email = prop.INVITATIONS_EMAIL;

        registrationPage = homePage.openRegistrationStep2(email, index);
    }

    @Then("check that Step 2 registration page opens for (.*)")
    public void checkStep2RegistrationStepOpens(String accountType) throws InterruptedException {

        registrationPage.checkStep2PageOpened(accountType);

    }
    @And("^enter additional details for (.*)  and click submit button$")
    public void finishStep2Registration(String accountType){

        registrationPage.enterAdditionalDetailsAndSubmit( accountType);


    }

    @Then("check confirmation message appears")
    public void checkConfirmationMessage() {
        registrationPage.checkRegistrationSuccess();
    }

    @And("close confirmation pop up")
    public void closeConfirmationPopUp() {
        homePageLoggedUser.closePopUp();
    }

    @After("@TaggedAgain")
    public void loggedOFF() {
        sitePage.logOFF();

    }
}
