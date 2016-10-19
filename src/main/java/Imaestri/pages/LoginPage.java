package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by syasenovich on 9/21/16.
 */
public class LoginPage extends AbstractPage{
    WebDriver driver;

    // public static By USERNAME_INPUT = By.id("email");
    // public static By PASSWORD_INPUT = By.id("pass");
    // public static By LOGIN_BUTTON = By.id("send2");
    @NameOfElement("Title")
    @FindBy(id = "login-module")
    public SelenideElement titleLoginPage;

    @NameOfElement("USERNAME_INPUT")
    @FindBy(id = "email")
    public SelenideElement loginName;

    @NameOfElement("PASSWORD_INPUT")
    @FindBy(id = "pass")
    public SelenideElement loginPassword;

    @NameOfElement("LOGIN_BUTTON")
    @FindBy(id = "send2")
    public SelenideElement button;


    public HomePageLoggedUser login(String username, String password) {

        // WebElement loginName = driver.findElement(USERNAME_INPUT);
        //WebElement pass = driver.findElement(PASSWORD_INPUT);
        //WebElement button = driver.findElement(LOGIN_BUTTON);
        // return new HomePageLoggedUser(driver) ;

        loginName.sendKeys(username);
        loginPassword.sendKeys(password);

        button.submit();
        sleep(20000);
        return page(HomePageLoggedUser.class);
    }
}

