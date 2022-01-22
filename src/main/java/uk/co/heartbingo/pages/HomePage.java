package uk.co.heartbingo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.utility.Utility;

import java.util.List;

public class HomePage extends Utility {
    // constructor used to initialise web elements with @FindBy annotation to this page
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//ul[@class='bvs-carousel__slider']//li[@class='section site-main-nav__item']//a")
    List<WebElement> menuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;


    public void clickOnLoginButton() {
        log.info("Clicking on Login button");
        pmClickOnElement(loginButton);

    }

    public void verifyUserIsOnHomePage() {

        String actual = driver.getCurrentUrl();
        log.info("Getting current URL : "+actual+"<br>");
        String expected = "heartbingo";
        Assert.assertTrue(actual.contains(expected));

    }

    public void clickOnMenuItems(String item) {

        for (WebElement menuItem : menuList) {

            if(menuItem.getText().equalsIgnoreCase(item)){
                log.info("Clicking on Top menu label : "+item+"<br>");
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
                        log.info("Getting URL for : "+item+"<br>");
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Jackpots":
                        pmWaitWithThreadSleep(10);
                        log.info("Getting URL for : "+item+"<br>");
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Slots":
                        pmWaitWithThreadSleep(10);
                        log.info("Getting URL for : "+item+"<br>");
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Casino":
                        pmWaitWithThreadSleep(10);
                        log.info("Getting URL for : "+item+"<br>");
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;

                    case "Promos":
                        pmWaitWithThreadSleep(10);
                        log.info("Getting URL for : "+item+"<br>");
                        Assert.assertTrue(driver.getCurrentUrl().contains(url));
                        break;
                }
                break;

            }
        }


    }


}
