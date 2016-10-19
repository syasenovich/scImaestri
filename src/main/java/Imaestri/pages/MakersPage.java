package Imaestri.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by syasenovich on 9/28/16.
 */
public class MakersPage extends SitePage{


    @NameOfElement("MakersTitle")
    @FindBy(css = ".toolbar-title")
    SelenideElement makersTitle;


    @NameOfElement("MakersURLs")
    @FindAll(@FindBy(css = ".images >a"))
    ElementsCollection link;


    public void checkOpening() {
       // makersTitle.shouldHave(attribute("textContent", "Makers"));
        if ( !makersTitle.getAttribute("textContent").contains("Makers"))
           Assert.fail("Makers page was not opened");


    }

    public String openAllMakersPages(boolean isLoggedIn) throws InterruptedException, AWTException {
        openAllItemsOnPage();
        String makersPageURL= url();
//        WebElement brandsContainer = driver.findElement(MAKERS_CONTAINER);
//        List<WebElement> link=driver.findElements(MAKERS_URLS);
//
//        //List<WebElement> link=brandsContainer.findElements(MAKERS_URLS);
//
//
//        // System.out.println("brands link number: " +link.size());
//        //System.out.println("brands link 0: " + link.get(0).getAttribute("href"));
        String FailureMessage = "";
        String FailureMessageTitles = "";
//
        for (int index=0; index<link.size(); index++ ) {
      // for (int index=3; index<10; index++ ) {

            String url = link.get(index).getAttribute("href");

            try {
//                JavascriptExecutor js =(JavascriptExecutor)getWebDriver();
//                js.executeScript("document.elementFromPoint(" + link.get(index).getLocation().x + "," + link.get(index).getLocation().y + ").click();");
                JavascriptExecutor ex = (JavascriptExecutor)getWebDriver();
                ex.executeScript("arguments[0].click();", link.get(index));

                // link.get(index).click();
                sleep(5000);

                try {
                   // WebElement brandContainer = getWebDriver().findElement(By.className("company-title"));

                    //if (brandContainer.getAttribute("textContent").isEmpty())
                    if($(".company-title").getText().isEmpty())
                        FailureMessage = FailureMessage + url + ", ";
                    else if ( !isLoggedIn ){
                        //check product's Titles

//                        List<WebElement> products = getWebDriver().findElements(By.cssSelector(".images-catalog >ul>li"));
                        ElementsCollection products = $$(By.cssSelector(".images-catalog >ul>li"));
//                        List<WebElement> imageLabel = getWebDriver().findElements(By.className("image-label"));
                        ElementsCollection imageLabel = $$(".image-label");

                        if(products.size() != 0 && imageLabel.size() !=0) {
                            int prIndex = 0;
                            do {

                                if (imageLabel.get(prIndex).getAttribute("textContent").length() == 0) {
                                    FailureMessageTitles = FailureMessageTitles + url;
                                    break;
                                }
                                prIndex++;

                        } while ( prIndex <= products.size() );
                        }
                        else if (imageLabel.size() ==0 && products.size() != 0 )
                            FailureMessageTitles = FailureMessageTitles + url + "; ";

                    }
                } catch (Exception e) {

                    //FailureMessage = FailureMessage + "Brand detail page was not opened: " + url + "; ";

                }


            } finally {
                open(makersPageURL);
                sleep(5000);
            }

        }
        if (FailureMessage.length() !=0)
                FailureMessage = "Brand detail page was not opened: " + FailureMessage;
        if(FailureMessageTitles.length() !=0)
            FailureMessageTitles = "Product Titles were not displayed for next brands: " + FailureMessageTitles;

            return FailureMessage + FailureMessageTitles;

//
    }

}
