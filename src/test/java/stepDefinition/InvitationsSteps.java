package stepDefinition;

import Imaestri.pages.GetPropertyValues;
import Imaestri.pages.InvitationsPage;
import Imaestri.pages.SendInvitationsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/10/16.
 */
public class InvitationsSteps {

    InvitationsPage invitationsPage =page(InvitationsPage.class);
    SendInvitationsPage sendInvitationsPage=page(SendInvitationsPage.class);
    private static GetPropertyValues prop;
    private String email;
    private String msg = "Hello, We'd like to invite you!";

    public static void readProperties() throws IOException {
        prop = new GetPropertyValues();
        prop.getPropValues();

    }



    @Then("enter email address")
    public void enterInvitationEmail() {
        email = prop.INVITATIONS_EMAIL;

        sendInvitationsPage.enterInvitationEmail(email);

    }

    @Then("enter message")
    public void enterInvitationMessage() {


        sendInvitationsPage.enterMessage(msg);

    }

    @And("check Invitation was sent")
    public void checkInvitationSent() {
        invitationsPage.checkSentMessage();
    }

    @Then("check Invitation status should be (.*)")
    public void checkInvitationStatus(String invitationStatusExpected) {

        invitationsPage.checkStatus(invitationStatusExpected);


    }
}
