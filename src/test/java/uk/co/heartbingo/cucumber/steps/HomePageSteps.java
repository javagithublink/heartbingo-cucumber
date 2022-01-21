package uk.co.heartbingo.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.heartbingo.pages.HomePage;

public class HomePageSteps {
    @Given("^User enters website URL on browser$")
    public void userEntersWebsiteURLOnBrowser() {
        new HomePage().verifyUserIsOnHomePage();
    }


    @When("^User clicks on log in button from top right corner of the page$")
    public void userClicksOnLogInButtonFromTopRightCornerOfThePage() {
        new HomePage().clickOnLoginButton();
    }


    @When("^User clicks on \"([^\"]*)\" item$")
    public void userClicksOnItem(String item) {
        new HomePage().clickOnMenuItems(item);
    }

    @Then("^User is able to navigate to \"([^\"]*)\" for \"([^\"]*)\"$")
    public void userIsAbleToNavigateToFor(String item, String url)  {
        new HomePage().verifyPageUrl(item,url);
    }
}
