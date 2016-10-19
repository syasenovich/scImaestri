package stepDefinition;

import Imaestri.pages.ProjectsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by syasenovich on 10/11/16.
 */
public class ProjectsSteps {

    ProjectsPage projectsPage=page(ProjectsPage.class);

    @And("check (.*) pop up appears")
     public void checkPopUpAppears(String name) {
        projectsPage.checkPopUpDisplayed(name);

    }

    @And("check (.*) pop up disappears")
    public void checkPopUpDisappears(String name) {
        projectsPage.checkPopUpNotDisplayed();

    }

    @And("enter Project Name (.*)")
    public void enterProjectName(String projectname) {
        projectsPage.enterProjectName(projectname);

    }

    @Then("check new project created with name (.*)")
    public void checkProjectdCreated(String projectname) {
        projectsPage.checkProjectCreated(projectname);

    }

    @And("open project (.*)")
    public void openCreatedProject(String prName) {
        projectsPage.openProjectPage(prName);

    }
    @Then("check created project (.*) page opens")
    public void checkCreatedProjectOpens(String prName) {
        projectsPage.checkProjectPage(prName);

    }

    @Then("check project with name (.*) deleted")
    public void checkProjectDeleted(String prName) {
        projectsPage.checkProjectDeleted(prName);

    }

    @And("select Project Name (.*) in drop down")
    public void selectProjectInDropDown(String prName) {
        projectsPage.selectProjectInDropDown(prName);

    }

    @And("check products (.*)and (.*) is added to the project")
    public void checkProductsAddedToProject(String productName1, String productName2) {
        projectsPage.checkProductsInProject(productName1,  productName2);

    }


//    @And("add product to project (.*)")
//    public void addProductToProject(String prName) {
//        projectsPage.addProductToProject(prName);
//
//    }


}
