package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by syasenovich on 10/6/16.
 */
public class ProductPage extends SitePage{

    @NameOfElement("ProductTitle")
    @FindBy(css = ".product-name >h1")
    SelenideElement productTitle;

    @NameOfElement("AddToCartButton")
    @FindBy(className = "btn-cart")
    //@FindBy(xpath = "//button[text()=\"+ Add to Cart\"]")
    SelenideElement addToCartButton;

    @NameOfElement("ConfirmationMsg")
    @FindBy(css = ".block-title>strong")
    SelenideElement confirmationMsg;

    @NameOfElement("ContinueShoppingButton")
    @FindBy(css = ".block-title>strong")
    SelenideElement continueShoppingButton;

    @NameOfElement("UpholsterySwatchSofia")
    @FindBy(id = "attr-swatch-opt-container-309-31153")
    SelenideElement upholsterySwatch;

    @NameOfElement("UpholsterySwatchDaisy")
    @FindBy(id = "attr-swatch-opt-container-310-25255")
    SelenideElement upholsterySwatchDaisy;


    @NameOfElement("SwatchYume")
    @FindAll(@FindBy(className = "qty"))
    ElementsCollection swatchYume;



    public void openProductPage(String productName) {

        searchProduct(productName);
    }


    public void checkProductPageOpens(String productName) {
        productTitle.shouldHave(exactText(productName.toUpperCase()));

    }

    public void addProductToPage() {


        //JavascriptExecutor ex = (JavascriptExecutor)getWebDriver();
       // ex.executeScript("arguments[0].click();",addToCartButton);
       // ex.executeScript("arguments[0].scrollIntoView(true);", $(byText("+ Add to Cart")));
       // addToCartButton.click();
        JavascriptExecutor jse = (JavascriptExecutor)getWebDriver();

        jse.executeScript("scroll(250, 0)"); // if the element is on top.
        addToCartButton.click();

        sleep(5000);

    }

    public void checkProductAddedToCart(String productName) {
        String expectedConfirmationMessage = "The item "+productName+" has been added to your cart";

        confirmationMsg.shouldHave(text(expectedConfirmationMessage.toUpperCase()));

    }

    public void clickContinueShopping() {

        $(byText("Continue shopping")).click();


    }

    public void selectProductConfiguration(String productName) {

        JavascriptExecutor jse = (JavascriptExecutor)getWebDriver();

        jse.executeScript("scroll(0, 400)"); // if the element is on top.

        if (productName.equalsIgnoreCase("Daisy"))
            upholsterySwatchDaisy.click();
        else if (productName.equalsIgnoreCase("Yume")) {
            swatchYume.get(0).sendKeys("1");
        }
        //$(byText("Logo")).click();
       // $(byText("Select Logo")).click();
      //  $(byText("Custom Logo")).click();

        sleep(1000);


    }

    public void clickGoToCart() {

        $(byText("Go to cart")).click();
        sleep(10000);
    }



    public CheckoutPage clickCheckout() {
        $(byText("Checkout")).click();
        sleep(5000);
        return page(CheckoutPage.class);
    }
}
