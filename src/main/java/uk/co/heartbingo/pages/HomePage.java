package uk.co.heartbingo.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.utility.Utility;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='bvs-carousel__slider']//li[@class='section site-main-nav__item']//a")
    List<WebElement> menuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bvs-site-logo bvs-site-logo_scrolling']")
    WebElement logoImage;


    public void clickOnLoginButton() {
        pmWaitWithThreadSleep(30);
        pmClickOnElement(loginButton);

    }

    public void verifyUserIsOnHomePage() {

        String actual = driver.getCurrentUrl();
        String expected = "heartbingo";
        Assert.assertTrue(actual.contains(expected));

    }

    public void verifyUserCanSeeHeartBingoLogo() {
        Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", logoImage);
        Assert.assertTrue(p);

    }


    public void clickOnMenuItems(String item) {

        for (WebElement menuItem : menuList) {

            if(menuItem.getText().equalsIgnoreCase(item)){
                menuItem.click();
                break;
            }


        }

    }

    public void verifyPageUrl(String item,String url){


        for(WebElement menuItem: menuList){

            if(menuItem.getText().equalsIgnoreCase(item)){
                switch (item) {

                    case "Bingo":
                        pmWaitWithThreadSleep(10);
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Jackpots":
                        pmWaitWithThreadSleep(10);
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Slots":
                        pmWaitWithThreadSleep(10);
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Casino":
                        pmWaitWithThreadSleep(10);
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Promos":
                        pmWaitWithThreadSleep(10);
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;
                }
                break;

            }
        }


    }


}
