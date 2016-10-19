package Imaestri.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by syasenovich on 10/11/16.
 */
public class ProjectsPage {
    @NameOfElement("CreateProjectButton")
    @FindBy(xpath = "//a[text()='+ Create New Project']")
    SelenideElement createProjectButton;

    @NameOfElement("ProjectPopUp")
    @FindBy(css = ".popup-block.active")
    SelenideElement projectPopUp;

    @NameOfElement("ProjectDropDown")
    @FindBy(css = ".form-list > li >div > div.pix-selectable")
    SelenideElement projectDropDown;

    @NameOfElement("PopUpTitle")
    @FindBy(css = ".popup-block.active > div.block-title")
    SelenideElement popUpTitle;

    @NameOfElement("ProjectNameInput")
    @FindBy(id = "wishlist-name")
    SelenideElement projectNameInput;

    @NameOfElement("ProjectsCreated")
    @FindAll(@FindBy(css = ".projects-list > tbody > tr >td.desc"))
    ElementsCollection projectsCreated;

    @NameOfElement("ViewProjects")
    @FindAll(@FindBy(css = ".projects-list > tbody > tr >td.p-link"))
    ElementsCollection viewProjects;

    @NameOfElement("ProjectTitle")
    @FindBy(css = ".sub-title>h2")
    SelenideElement projectTitle;

    @NameOfElement("ProductsList")
    @FindAll(@FindBy(css = "div.item-header > h3.product-name"))
    ElementsCollection productsList;


    @NameOfElement("AddToProjecttButton")
    @FindBy(className = "link-wishlist")
    //@FindBy(xpath = "//button[text()=\"+ Add to Cart\"]")
    SelenideElement addToProjectButton;


    public void clickCreateProject() {
        createProjectButton.click();
        sleep(1000);

    }

    public void checkPopUpDisplayed(String popupTitle) {
        projectPopUp.shouldBe(Condition.visible);
        popUpTitle.shouldHave(text(popupTitle));

    }

    public void enterProjectName(String prName) {

        projectNameInput.sendKeys(prName);
        sleep(1000);
    }

    public void checkPopUpNotDisplayed() {

        projectPopUp.shouldNotBe(Condition.visible);
    }

    public void checkProjectCreated(String projectname) {

        $$(By.cssSelector(".projects-list > tbody > tr >td.desc")).get($$(By.cssSelector(".projects-list > tbody > tr >td.desc")).size() - 1).shouldHave(text(projectname));
        //projectsCreated.get(projectsCreated.size()-1).shouldHave(text(projectname));

    }



    public void openProjectPage(String projectName) {
      //  viewProjects.get(projectsCreated.size()-1).click();
        //$$(By.cssSelector(".projects-list > tbody > tr >td.p-link >a")).get($$(By.cssSelector(".projects-list > tbody > tr >td.desc")).size() - 1).click();
        //$$(By.cssSelector(".projects-list > tbody > tr >td.p-link >a")).$(byText(projectName)).click();
        $$(By.cssSelector(".projects-list > tbody > tr")).findBy(text(projectName)).$(By.cssSelector(".p-link > a")).click();
        sleep(10000);
    }

    public void checkProjectPage(String projectname) {

        projectTitle.shouldHave(text(projectname));
    }

    public void checkProjectDeleted(String prName) {
        $$(By.cssSelector(".projects-list > tbody > tr >td.desc")).get($$(By.cssSelector(".projects-list > tbody > tr >td.desc")).size() - 1).shouldNotHave(text(prName));
        //projectsCreated.get(projectsCreated.size()-1).shouldNotHave(text(prName));

    }

    public void clickAddToProject() {

        JavascriptExecutor jse = (JavascriptExecutor)getWebDriver();

        jse.executeScript("scroll(250, 0)"); // if the element is on top.
        addToProjectButton.click();

        sleep(5000);
    }

    public void selectProjectInDropDown(String prName) {
        projectDropDown.click();
        projectDropDown.$(By.className("pix-selectable-list")).$(byText(prName)).click();
        sleep(5000);

    }


    public void checkProductsInProject(String productNameFirst, String productNameSecond) {
        productsList.shouldHave(texts(productNameFirst, productNameSecond));
        //shouldHave(text(productname));
    }
}
