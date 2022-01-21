package uk.co.heartbingo.cucumber.steps;

import cucumber.api.java.en.And;
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

    @And("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersAnd(String userName, String password) {
        new LoginPage().enterUserName(userName);
        new LoginPage().enterPassword(password);

    }

    @And("^User clicks on 'Log in' button$")
    public void userClicksOnLogInButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("^User can see 'The username or password you entered is incorrect\\.' error message$")
    public void userCanSeeTheUsernameOrPasswordYouEnteredIsIncorrectErrorMessage() {
        new LoginPage().verifyUnsuccessfulLoginAttempt();
    }
}
