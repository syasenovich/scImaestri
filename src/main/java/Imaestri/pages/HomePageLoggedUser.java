package Imaestri.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by syasenovich on 9/21/16.
 */
public class HomePageLoggedUser {

//    public static final By RESIDENTIAL_MENU = By.xpath("//a[text()='Residential']");
//    public static final By SEATING_MENU = By.xpath("//a[text()='Seating']");
//    public static final By SEARCH_ICON = By.className("search-link");
//    public static final By MAKERS_MENU = By.xpath("//a[text()='Makers']");
//    public static final By DESIGNERS_MENU = By.xpath("//a[text()='Designers']");
//    public static final By SEARCH_INPUT_FIELD = By.id("search");
//    public static final By SEARCH_AUTOCOMPLETE_PREVIEW = By.className("asearch-preview");
//    public static final By SUGGEST_LINKS =  By.cssSelector(".block-products >ul >li");


    @NameOfElement("ResidentialMenu")
    @FindBy(xpath = "//a[text()='Residential']")
    SelenideElement residentialMenu;

    @NameOfElement("OutdoorMenu")
    @FindBy(xpath = "//a[text()='Outdoor & Lighting']")
    SelenideElement outdoorMenu;

    @NameOfElement("Office")
    @FindBy(xpath = "//a[text()='Office']")
    SelenideElement officeMenu;

    @NameOfElement("CloseIcon")
    @FindBy(className = "btn-close")
    SelenideElement closeIcon;

    @NameOfElement("AccountLink")
    @FindBy(xpath = "//a[text()='Account']")
    SelenideElement accountLink;


    public SitePage openSitePage(String menuName) {

        $(By.xpath("//a[text()='"+menuName.replaceAll("\\W", "")+"']")).click();
        sleep(15000);
        //WebElement menuItem = driver.findElement(MAKERS_MENU);
        // makersMenu.click();
        return page(SitePage.class);
    }

    public SitePage openResidentialCategoryPage(String menuName) {

        residentialMenu.click();
        $(By.xpath("//a[text()='"+menuName.replaceAll("\\W", "")+"']")).click();
        sleep(10000);
        return page(SitePage.class);

    }
    public SitePage openOutdoorCategoryPage(String menuName) {

        outdoorMenu.click();
        $(By.xpath("//a[text()='"+menuName.replaceAll("\\W", "")+"']")).click();
        sleep(10000);
        return page(SitePage.class);

    }
    public SitePage openOfficeCategoryPage(String menuName) {

        officeMenu.click();
        $(By.xpath("//a[text()='"+menuName.replaceAll("\"", "")+"']")).click();
        sleep(15000);
        return page(SitePage.class);

    }

    public void closePopUp() {
        closeIcon.click();
        sleep(1000);

    }

    public AccountPage openMyAccountMenu(String menuName) {
        accountLink.click();

        $(By.xpath("//a[text()='"+menuName.replaceAll("\"", "")+"']")).click();
        sleep(5000);
        return page(AccountPage.class);
    }
}
