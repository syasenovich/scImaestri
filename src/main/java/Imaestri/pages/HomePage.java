package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by syasenovich on 9/21/16.
 */
public class HomePage extends AbstractPage{
    MakersPage makersPage=page(MakersPage.class);

    @NameOfElement("LOG IN")
    @FindBy(xpath = "//a[.='Log in']")
    public SelenideElement loginButton;

    @NameOfElement("Makers")
    @FindBy(xpath = "//a[.='Makers']")
    public SelenideElement makersMenu;

    @NameOfElement("JoinNow")
    @FindBy(className = "register-cta")
    public SelenideElement joinMenu;

    @NameOfElement("EmailInput")
    @FindBy(css = "#email_address")
    public SelenideElement emailInput;

    @NameOfElement("AccountTypeDropDown")
    @FindBy(className = "pix-selectable")
    public SelenideElement accountTypeDropDown;


    @NameOfElement("AccountsList")
    @FindBy(className = "pix-selectable-list")
    public SelenideElement accountsList;

    @NameOfElement("SubmitButton")
    @FindBy(id = "reg-form-submit")
    public SelenideElement submitButton;

    @NameOfElement("LeftMenuItems")
    @FindAll(@FindBy(className = "nav--main__level__list__item"))
    ElementsCollection leftMenuItems;

    @NameOfElement("Logo")
    @FindBy(xpath = "//img[@alt='IMAESTRI']")
    public SelenideElement logo;

    @NameOfElement("AuthLogo")
    @FindBy(xpath = "//img[@alt='Authorize.Net Merchant - Click to Verify']")
    public SelenideElement authLogo;

    @NameOfElement("FooterItems")
    @FindAll(@FindBy(className = "footer-link"))
    ElementsCollection footerItems;


    public LoginPage openLoginPage() {
        // List<WebElement> headerLinks = driver.findElements(RIGHT_NAV_MENU);
        // headerLinks.get(1).click();
        //  return new LoginPage(driver);
        loginButton.click();
        return page(LoginPage.class);

    }

    public MakersPage openMakersPage() {
        makersMenu.click();
        sleep(5000);
        return page(MakersPage.class);
    }

    public void openRegistrationStep1() {
        joinMenu.click();
        sleep(10000);

    }

    public RegistrationPage openRegistrationStep2(String email, int accountIndex) throws InterruptedException {

        emailInput.sendKeys(email);
        accountTypeDropDown.click();
        $(accountsList).$$(".pix-selectable-item").get(accountIndex).click();

        submitButton.submit();
        sleep(10000);

        return page(RegistrationPage.class);
    }

    public void checkHeaderForNotLoggedUser() {
        sleep(5000);
        String homePageURL= url();


        try {
            leftMenuItems.get(0).shouldHave(text("About"));
            leftMenuItems.get(0).click();
            $(By.className("about-header")).shouldHave(text("About Us"));

            open(homePageURL);

            leftMenuItems.get(1).shouldHave(text("Makers"));
            leftMenuItems.get(1).click();
            makersPage.checkOpening();

            open(homePageURL);

            leftMenuItems.get(2).shouldHave(text("Blog"));
            leftMenuItems.get(2).click();
            if ( !title().contains("Blog") )
                Assert.fail("Blog page is not opens");

            joinMenu.shouldHave(text("Join Now"));
            leftMenuItems.get(4).shouldHave(text("Log in"));

        } catch (NoSuchElementException e) {

            throw(e);
        }
        if (!$(By.xpath("//img[@alt='IMAESTRI']")).exists())
            Assert.fail("There is no logo on the page");
        else {
            $(By.xpath("//img[@alt='IMAESTRI']")).click();


        }
    }

    public void checkFooterForNotLoggedUser() {
        if (!$(By.xpath("//img[@alt='Authorize.Net Merchant - Click to Verify']")).exists())
            Assert.fail("There is no authorization logo on the page");

        try {
            footerItems.get(0).shouldHave(text("Contact Us"));

            footerItems.get(1).shouldHave(text("FAQ"));
            footerItems.get(2).shouldHave(text("Privacy Policy"));
            footerItems.get(3).shouldHave(text("Terms Of Use"));

        } catch (NoSuchElementException e) {

            throw(e);
        }

    }
}
