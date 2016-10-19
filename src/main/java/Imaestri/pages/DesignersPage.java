package Imaestri.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by syasenovich on 10/5/16.
 */
public class DesignersPage extends SitePage{

    @NameOfElement("DesignersURLs")
    @FindAll(@FindBy(xpath = "//div[@class='image']/a"))
    ElementsCollection link;

    public String openAllDesignersPages() throws InterruptedException, AWTException {

        openAllItemsOnPage();
        String designersPageURL= url();

        String FailureMessage = "";

//
        for (int index=0; index<link.size(); index++ ) {
            // for (int index=3; index<10; index++ ) {

            String url = link.get(index).getAttribute("href");

            try {
                JavascriptExecutor ex = (JavascriptExecutor)getWebDriver();
                ex.executeScript("arguments[0].click();", link.get(index));

                sleep(5000);

                try {

                    if($("#cat-title").getText().isEmpty())
                        FailureMessage = FailureMessage + url + ", ";

                } catch (Exception e) {

                    FailureMessage = FailureMessage + "Designers detail page was not opened: " + url + "; ";

                }
                finally {
                    open(designersPageURL);

                }


            }catch (Exception e) {

                FailureMessage = FailureMessage + "Designers detail page was not opened: " + url + "; ";

            }
            finally {
               // open(designersPageURL);
                sleep(5000);
            }

        }
        if (FailureMessage.length() !=0)
            FailureMessage = "Brand detail page was not opened: " + FailureMessage;

        return FailureMessage;

//
    }
}
