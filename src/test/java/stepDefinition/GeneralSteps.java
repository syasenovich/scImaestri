package stepDefinition;

import Imaestri.pages.*;
import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/11/16.
 */
public class GeneralSteps {
    private static GetPropertyValues prop;

    HomePageLoggedUser homePageLoggedUser = page(HomePageLoggedUser.class);
    //private  SeatingCategoryPage seatingCategoryPage;
    HomePage homePage = page(HomePage.class);
    SitePage sitePage = page(SitePage.class);
    LoginPage loginPage = page(LoginPage.class);
    MakersPage makersPage = page(MakersPage.class);
    CheckoutPage checkoutPage = page(CheckoutPage.class);
    AccountPage accountPage=page(AccountPage.class);
    InvitationsPage invitationsPage=page(InvitationsPage.class);
    SendInvitationsPage sendInvitationsPage=page(SendInvitationsPage.class);
    ProjectsPage projectsPage=page(ProjectsPage.class);

    public static void readProperties() throws IOException {
        prop = new GetPropertyValues();
        prop.getPropValues();

    }

    @Given("Browser is started and home page is opened")
    public void browserStartedAndHomePageOpen() throws IOException {

        readProperties();
        homePage =  open(prop.URL, HomePage.class);
    }

    //selenide
    @Given("login to web site")
    public void loginImaestri () {

        loginPage = homePage.openLoginPage();
        homePageLoggedUser = loginPage.login(prop.USERNAME, prop.PASSWORD);
    }
    @And("^check that (.*) page opens$")
    public void checkThatPageIsOpened(String pageName) {

        if (pageName.equals("Log In")) {
            loginPage.get("Title").shouldBe(Condition.appears);

        }
        else if (pageName.equals("Makers")) {
            makersPage.checkOpening();

        }

        else if (pageName.equals("Checkout")) {
            checkoutPage.checkOpening();

        }
        else if (pageName.equals("My Account")) {
            accountPage.checkOpening();

        }
        else if (pageName.equals("Invitations")) {
            invitationsPage.checkOpening();

        }
        else if (pageName.equals("Send Invitations")) {
            sendInvitationsPage.checkOpening();

        }


    }

    @And("^open (.*) page$")
    public void openSitePage( String menuName) {
        if (menuName.equals("Log In")) {
            loginPage = homePage.openLoginPage();

        }
        else if (menuName.equals("\"Preview Makers\"")) {
            makersPage = homePage.openMakersPage();

        }
        else if (menuName.equals("Registration")) {
            homePage.openRegistrationStep1();

        }
        else if (menuName.equals("Seating")  )
            homePageLoggedUser.openResidentialCategoryPage(menuName);

        else if (menuName.equals("Outdoor") )
            homePageLoggedUser.openOutdoorCategoryPage(menuName);

        else if  (menuName.equals("Office Tables & Desks") )
            homePageLoggedUser.openOfficeCategoryPage(menuName);

        else if  (menuName.equals("Invitations") || menuName.equals("My Projects") )
            sitePage = accountPage.openSpecificAccountMenu(menuName);

        else if  (menuName.equals("My Account") )
            accountPage = homePageLoggedUser.openMyAccountMenu(menuName);


        else sitePage = homePageLoggedUser.openSitePage(menuName);
    }

    @Then("click (.*) button")
    public void clickInvitationsButton(String btnName) {

        if (btnName.equals("Send Invitations"))
            invitationsPage.clickInvitationsButton();

        else if (btnName.equals("+ Create New Project"))
            projectsPage.clickCreateProject();

        else if (btnName.equals("Add to Project"))
            projectsPage.clickAddToProject();

        else if (btnName.equals("Cancel"))
            sitePage.clickCancelButton();

        else if (btnName.equals("Save"))
            sitePage.clickSaveButton();

        else if (btnName.equals("Delete"))
            sitePage.clickDeleteButton();
    }
    @And("click Delete link")
    public void clickDeleteLink() {
        sitePage.clickDeleteLink();
    }
}
