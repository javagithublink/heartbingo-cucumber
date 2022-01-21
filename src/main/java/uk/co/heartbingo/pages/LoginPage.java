package uk.co.heartbingo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.utility.Utility;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy (xpath = "//a[@class='active']")
    WebElement loginText;

    @CacheLookup
    @FindBy (xpath = "//iframe[@class='oneauth-iframe']")
    WebElement loginFrame;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Log In >']")
    WebElement loginButton;

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'The username or password you entered is incorrect.')]")
    WebElement loginErrorMessage;

    @CacheLookup
    By userNamePath = By.xpath("//input[@id='username']");

    @CacheLookup
    @FindBy (xpath = "//input[@id='password']")
    WebElement passwordPath;





    public void verifyUserIsOnLoginPopUp(){

        String actual = driver.getCurrentUrl();
        log.info("Getting Login URL : "+actual+"<br>");
        String expected = "https://www.heartbingo.co.uk/en-gb/login?first_modal=true";

        Assert.assertTrue(expected.contains(actual));


    }

    public void enterUserName(String userName){
        log.info("Switching to iFrame and entering userName : "+userName+"<br>");
        driver.switchTo().frame(loginFrame).findElement(userNamePath).sendKeys(userName);
    }

    public void enterPassword(String password){
        pmWaitWithThreadSleep(20);
        log.info("Entering password : "+password+"<br>");
        pmSendTextToElement(passwordPath,password);
    }

    public void clickOnLoginButton(){
        pmWaitWithThreadSleep(20);
        log.info("Clicking on login button <br>");
        pmClickOnElement(loginButton);
    }

    public void verifyUnsuccessfulLoginAttempt(){
        pmWaitWithThreadSleep(20);
        log.info("Getting error message : "+loginErrorMessage+"<br>");
        String actual = pmGetTextFromElement(loginErrorMessage);
        String expected = "The username or password you entered is incorrect";
        Assert.assertTrue(actual.contains(expected));

    }

}
