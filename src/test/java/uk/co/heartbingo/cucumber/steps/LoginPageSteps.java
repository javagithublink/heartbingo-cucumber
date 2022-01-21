package uk.co.heartbingo.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.heartbingo.pages.HomePage;
import uk.co.heartbingo.pages.LoginPage;

public class LoginPageSteps {
    @When("^User clicks on log in button from top right corner of the page$")
    public void userClicksOnLogInButtonFromTopRightCornerOfThePage() {
        new HomePage().clickOnLoginButton();
    }

    @Then("^User can see log in popup$")
    public void userCanSeeLogInPopup() {
        new LoginPage().verifyUserIsOnLoginPopUp();
    }
}
