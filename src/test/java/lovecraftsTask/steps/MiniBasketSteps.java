package lovecraftsTask.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lovecraftsTask.pages.BasketPage;
import lovecraftsTask.pages.MiniBasketPage;
import lovecraftsTask.pages.PaintBoxYarnsSimpleAranPage;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.BeforeClass;


/**
 * Created by Vladyslav Vlasov on 24.01.2017.
 */

public class MiniBasketSteps {
    PaintBoxYarnsSimpleAranPage paintBoxYarnsSimpleAranPage;
    MiniBasketPage miniBasket;
    BasketPage basketPage;

    @Given("^I am on \"([^\"]*)\"$")
    public void iAmOn(String arg0) {
        paintBoxYarnsSimpleAranPage
                .openPage()
                .checkThatYouOnCorrectPage();
    }

    @When("^I add (\\d+) \"([^\"]*)\" yarns to my basket$")
    public void iAddYarnsToMyBasket(int arg0, String arg1) {
        paintBoxYarnsSimpleAranPage
                .selectQuantity(arg0)
                .selectColor(arg1)
                .addToBasket()
                .checkConfirmationMessage(arg1, arg0)
                .closeConfirmationMessage();
    }

    @Then("^I can see \"([^\"]*)\" yarn in the minibasket$")
    public void iCanSeeYarnInTheMinibasket(String arg0) {
        miniBasket
                .clickOnMiniBasket()
                .checkCorrectMiniBasketInfo(arg0);
    }

    @When("^I use minibasket to follow to the basket page$")
    public void iUseMinibasketToFollowToTheBasketPage() {
        miniBasket
                .clickGoToBasket();
        basketPage
                .checkThatYouOnCorrectPage();

    }

    @Then("^I can see \"([^\"]*)\" on the basket page$")
    public void iCanSeeOnTheBasketPage(String arg0) {

        basketPage
                .closePopUpWindowIfPresent()
                .checkCorrectProductAddedOnBasketPage(arg0);
    }
}
