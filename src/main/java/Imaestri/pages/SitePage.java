package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by syasenovich on 9/21/16.
 */
public class SitePage extends AbstractPage {
//    WebDriver driver;
//    public static final By PAGE_NUMBERS =  By.xpath("//div[@class='pages']/ol/li");
//    public static final By PAGE_CURRENT =  By.className("current");

    @NameOfElement("Account")
    @FindBy(xpath = "//a[.='Account']")
    SelenideElement accountLink;

    @NameOfElement("SignOUT")
    @FindBy(xpath = "//a[.='Sign Out']")
    SelenideElement signOUT;

    @NameOfElement("CurrentPageNumber")
    @FindBy(css = ".current")
    SelenideElement currentPageNumber;

    @NameOfElement("PageNumbers")
    @FindAll(@FindBy(xpath = "//div[@class='pages']/ol/li"))
    ElementsCollection pageNumbersElement;

    @NameOfElement("Spinner")
    @FindBy(css = ".please-wait")
    SelenideElement spinner;

    @NameOfElement("PageLimiter")
    @FindBy(css = ".pix-selectable-trigger")
    SelenideElement pageLimiter;

    @NameOfElement("PageLimiterList")
    @FindAll(@FindBy(css = ".limiter"))
    SelenideElement pageLimiterList;


    @NameOfElement("PageLimiterItem")
    @FindAll(@FindBy(css = ".pix-selectable-item"))
    ElementsCollection pageLimiterItem;

    @NameOfElement("SearchIcon")
    @FindBy(className = "search-link")
    public SelenideElement searchIcon;

    @NameOfElement("SearchInput")
    @FindBy(id = "search")
    public SelenideElement searchInput;

    @NameOfElement("SearchAutocomplete")
    @FindBy(className = "asearch-preview")
    public SelenideElement searchAutocomplete;

    @NameOfElement("CancelButton")
    @FindBy(className = "btn-cancel")
    public SelenideElement cancelButton;

    @NameOfElement("SaveButton")
    @FindBy(className = "btn-save")
    public SelenideElement saveButton;

    @NameOfElement("DeleteLink")
    @FindBy(xpath = "//a[text()='Delete']")
    public SelenideElement deleteLink;

    public void clickPageInPagination(String pageNumber) {

        $$(pageNumbersElement).get(Integer.parseInt(pageNumber)).click();


    }

    public void checkPageOpens(String pageNumber) {
        currentPageNumber.shouldHave(text(pageNumber));

    }

    public void logOFF() {
        accountLink.click();
        signOUT.click();
        sleep(5000);


    }
    public void openAllItemsOnPage() throws InterruptedException {

        pageLimiter.click();
        $(pageLimiterList).$$(".pix-selectable-item").get(2).click();
        sleep(5000);


    }

    public void openNewTab() throws InterruptedException {


        ArrayList<String> tabs = new ArrayList<String> (getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(0));


    }

    public ProductPage searchProduct(String productName) {
        searchIcon.click();
        sleep(1000);
        searchInput.val(productName).pressEnter();
        //searchInput.sendKeys(Keys.ENTER);
        sleep(10000);

       // $(By.linkText(productName)).click();
        $$(By.cssSelector(".info> div.product-name >a")).get(0).click();
       // $(searchAutocomplete).$$(By.cssSelector(".block-products >ul >li")).get(0).click();
       // $(searchAutocomplete).$$(By.cssSelector(".block-products >ul >li")).get(0).click();
       sleep(10000);

        return page(ProductPage.class);

    }


    public void clickCancelButton() {
        cancelButton.click();
        sleep(1000);

    }

    public SitePage clickSaveButton() {
        saveButton.click();
        sleep(5000);
        return page(SitePage.class);
    }

    public SitePage clickDeleteButton() {
        saveButton.click();
        sleep(5000);

        return page(SitePage.class);
    }

    public void clickDeleteLink() {

        deleteLink.click();
        sleep(5000);
    }
}

