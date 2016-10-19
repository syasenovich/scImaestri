package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by syasenovich on 10/7/16.
 */
public class CheckoutPage {

    @NameOfElement("CheckoutTitle")
    @FindBy(className = "page-title")
    SelenideElement checkoutTitle;

    public void checkOpening() {
        checkoutTitle.shouldHave(text("Checkout"));
    }
}
