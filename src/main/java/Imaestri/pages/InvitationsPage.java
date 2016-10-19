package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by syasenovich on 10/10/16.
 */
public class InvitationsPage {
    @NameOfElement("InvitationsTitle")
    @FindBy(css = "div.block-account > div.block-content > ul >li.current")
    SelenideElement invitationsTitle;

    @NameOfElement("SendInvitationsButton")
    @FindBy(className = "button")
    SelenideElement sendInvitationsButton;

    @NameOfElement("SendStatusMessage")
    @FindBy(className = "messages")
    SelenideElement sendStatusMessage;


    @NameOfElement("LastInvitationAccepted")
    @FindAll(@FindBy(css = ".first.odd>td"))
    ElementsCollection lastInvitationAccepted;

    private static GetPropertyValues prop;

   private String successMsg;


    public static void readProperties() throws IOException {
        prop = new GetPropertyValues();
        prop.getPropValues();

    }
    private String email = prop.INVITATIONS_EMAIL;

    public void checkOpening() {
        invitationsTitle.shouldHave(text("Invitations"));
    }

    public void clickInvitationsButton() {
        sendInvitationsButton.click();
        sleep(5000);

    }

    public void checkSentMessage() {

        successMsg = "Invitation for "+email+" has been sent.";
        sendStatusMessage.shouldHave(text(successMsg));

    }

    public void checkStatus(String invitationStatusExpected) {
        lastInvitationAccepted.get(0).shouldHave(text(email));

        lastInvitationAccepted.get(1).shouldHave(text(invitationStatusExpected));
    }
}
