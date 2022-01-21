package uk.co.heartbingo.pages;

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

    @CacheLookup
    @FindBy (xpath = "//a[@class='active']")
    WebElement loginText;

    @CacheLookup
    @FindBy (xpath = "//iframe[@class='oneauth-iframe']")
    WebElement loginFrame;


    public void verifyUserIsOnLoginPopUp(){

        String actual = driver.switchTo().frame(loginFrame).findElement(By.xpath("//a[@class='active']")).getText();
        String expected = "Log In";

        Assert.assertTrue(expected.contains(actual));


    }


}
