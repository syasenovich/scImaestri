package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by syasenovich on 10/7/16.
 */
public class ShoppingCartPage {
    @NameOfElement("ShoppingCartTitle")
    @FindBy(id = "current-cart-qty")
    SelenideElement shoppingCartTitle;

    public void checkShoppingCartPageOpened() {

        shoppingCartTitle.shouldHave(text("Shopping Cart"));


    }
}
