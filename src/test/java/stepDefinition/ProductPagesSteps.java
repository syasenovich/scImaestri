package stepDefinition;


import Imaestri.pages.ProductPage;
import Imaestri.pages.ShoppingCartPage;
import Imaestri.pages.SimpleProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/6/16.
 */
public class ProductPagesSteps {

    ProductPage productPage = page(ProductPage.class);
    ShoppingCartPage shoppingCart = page(ShoppingCartPage.class);

    @And("open page for product (.*)")
    public void openProductPage (String productName) {

        productPage.openProductPage(productName);

    }

    @And("check that product page opens for (.*)")
    public void checkProductPage (String productName) {
        productPage.checkProductPageOpens(productName);
    }

    @And("add product to cart")
    public void addProductToCart () {

        productPage.addProductToPage();

    }

    @Then("check confirmation msg that product (.*) added to cart")
    public void checkProductConfirmationMsg(String productName) {
        productPage.checkProductAddedToCart(productName);
    }

    @And("continue shopping")
    public void continueShopping() {
        productPage.clickContinueShopping();

    }

    @And("select product (.*) configuration")
    public void selectProductConfiguration(String productName) {
        productPage.selectProductConfiguration(productName);

    }

    @And("go to shopping cart")
    public void goToShoppingCart () {
        productPage.clickGoToCart();
    }

    @Then("check shopping cart page opens")
    public void checkShoppingCartPageOpened() {
        shoppingCart.checkShoppingCartPageOpened();
    }

    @And("click Checkout")
    public void clickChekout() {
        productPage.clickCheckout();
    }
}
