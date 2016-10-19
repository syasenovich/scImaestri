package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by syasenovich on 10/10/16.
 */
public class SendInvitationsPage {
    @NameOfElement("pageTitle")
    @FindBy(className = "page-title")
    SelenideElement pageTitle;

    @NameOfElement("InputEmail")
    @FindBy(id = "email_1")
    SelenideElement inputEmail;

    @NameOfElement("InputMessage")
    @FindBy(id = "message")
    SelenideElement inputMsg;

    public void checkOpening() {
        pageTitle.shouldHave(text("Send Invitations"));
    }


    public void enterInvitationEmail(String email) {

        inputEmail.sendKeys(email);

    }

    public void enterMessage(String msg) {

        inputMsg.sendKeys(msg);

    }
}
