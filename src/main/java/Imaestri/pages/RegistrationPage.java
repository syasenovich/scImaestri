package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by syasenovich on 10/4/16.
 */
public class RegistrationPage {
    @NameOfElement("REGISTRATION_PAGE_TEXT")
    @FindBy(xpath = "//div[@class='content-column']")
    public SelenideElement step2Text;

    @NameOfElement("FIRST_NAME_INPUT")
    @FindBy(id = "first_name")
    public SelenideElement firstNameInput;

    @NameOfElement("LAST_NAME_INPUT")
    @FindBy(id = "last_name")
    public SelenideElement lastNameInput;

    @NameOfElement("PHONE_INPUT")
    @FindBy(id = "customer_telephone")
    public SelenideElement phoneInput;

    @NameOfElement("PASSWORD_INPUT")
    @FindBy(id = "password")
    public SelenideElement passwordInput;

    @NameOfElement("VERIFY_PASSWORD_INPUT")
    @FindBy(id = "verify_password")
    public SelenideElement verifyPasswordInput;

    @NameOfElement("BUTTON_SUBMIT")
    @FindBy(className = "button_signup")
    public SelenideElement submitLogInButton;

    @NameOfElement("COMPANY_TYPE_SELECTOR")
    @FindBy(id = "company_type")
    public SelenideElement companyTypeSelector;

    @NameOfElement("COMPANY_INPUT")
    @FindBy(id = "company")
    public SelenideElement companyNameInput;

    @NameOfElement("STREET_INPUT")
    @FindBy(id = "street_1")
    public SelenideElement streetInput;

    @NameOfElement("CITY_INPUT")
    @FindBy(id = "city")
    public SelenideElement cityInput;

    @NameOfElement("ZIP_INPUT")
    @FindBy(id = "zip")
    public SelenideElement zipInput;

    @NameOfElement("TELEPHONE_INPUT")
    @FindBy(id = "telephone")
    public SelenideElement telephoneInput;

    @NameOfElement("SUCCESS_MSG")
    @FindBy(css = ".block-content >h1")
    public SelenideElement successSignup;

    @NameOfElement("STATE_LIST")
    @FindBy(id = "region_id")
    public SelenideElement dropStateList;

    @NameOfElement("REF_CODE")
    @FindBy(id = "reference_code")
    public SelenideElement refCode;

    private static GetPropertyValues prop;
    private String email;

    public static void readProperties() throws IOException {
        prop = new GetPropertyValues();
        prop.getPropValues();

    }

    public void checkStep2PageOpened(String caseAccount) {


        if (caseAccount.equals("Consumer")) {
            step2Text.shouldHave(text("COMPLETE YOUR ACCOUNT REGISTRATION"));

        } else if (caseAccount.equals("Business")) {
            step2Text.shouldHave(text("COMPLETE YOUR BUSINESS ACCOUNT REGISTRATION"));


        } else if (caseAccount.equals("Design Trade")) {
            step2Text.shouldHave(text("COMPLETE YOUR DESIGN TRADE ACCOUNT REGISTRATION"));

        }

    }

    public void enterAdditionalDetailsAndSubmit(String caseAccount) {
        enterRegistrationFields(caseAccount);
        submitLogInButton.submit();

        sleep(10000);

    }

    public void checkRegistrationSuccess() {
        successSignup.shouldHave(text("THANK YOU FOR JOINING"));
    }

    public void enterRegistrationFields(String accountType) {
        firstNameInput.sendKeys("Sveta");
        lastNameInput.sendKeys("Yasenovich");
        phoneInput.sendKeys("2012039194");
        passwordInput.sendKeys("1234567");
        verifyPasswordInput.sendKeys("1234567");

        if (accountType.equals("Business") || accountType.equals("Design Trade") ) {
            companyNameInput.sendKeys("Qa Test");
            streetInput.sendKeys("21 2nd street");
            cityInput.sendKeys("Jersey City");
            zipInput.sendKeys("07302");
            telephoneInput.sendKeys("2012039198");


            dropStateList.selectOption("New Jersey");


        }
        if ( accountType.equals("Design Trade")) {


            companyTypeSelector.selectOption("Other");
          //  selectByVisibleText("Other");
        }
        if ( accountType.equals("Consumer Invitations")) {


            refCode.sendKeys(prop.REFERENCE_CODE);

        }


    }



}
