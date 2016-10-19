package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by syasenovich on 10/10/16.
 */
public class AccountPage {
    @NameOfElement("AccountTitle")
    @FindBy(css = "div.block-account >div.block-title")
    SelenideElement accountTitle;

    @NameOfElement("MenuItem")
    @FindAll(@FindBy(css = "div.navigation-left > ul > li"))
    ElementsCollection menuItem;




    public void checkOpening() {
        accountTitle.shouldHave(text("My Account"));
    }

    public SitePage openSpecificAccountMenu(String menuName) {

        JavascriptExecutor ex = (JavascriptExecutor)getWebDriver();
        if (menuName.equals("My Projects"))
            menuItem.get(1).click();
        else
        ex.executeScript("arguments[0].click();", $(By.xpath("//a[text()='" + menuName.replaceAll("\\W", "") + "']")));

       // $(By.xpath("//a[text()='" + menuName.replaceAll("\\W", "") + "']")).click();
        sleep(5000);
        //WebElement menuItem = driver.findElement(MAKERS_MENU);
        // makersMenu.click();
        return page(SitePage.class);
    }
}
