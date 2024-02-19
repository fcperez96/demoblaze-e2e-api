package demoblaze.stepdefinitions.e2e;

import demoblaze.navigation.NavigateTo;
import demoblaze.tasks.Add;
import demoblaze.tasks.EnterTo;
import demoblaze.tasks.Place;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static demoblaze.pages.CartPage.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyProductStepDefinitions {

    @When("{actor} add two products in the cart to buy")
    public void buyerAddTwoProductsInTheCartToBuy(Actor actor) {
        NavigateTo.demoblazeHomePage().performAs(actor);
        Add.twoRandomProducts().performAs(actor);
    }

    @Then("{actor} should see the productos in the cart")
    public void heShouldSeeTheProductosInTheCart(Actor actor) {
        String firstProductName = actor.recall("productOneName");
        String secondProductName = actor.recall("productTwoName");
        EnterTo.shoppingCart().performAs(actor);
        List<String> cartProductList = CART_PRODUCT_LIST.resolveAllFor(actor).texts();
        actor.attemptsTo(
                Ensure.that(firstProductName).isIn(cartProductList),
                Ensure.that(secondProductName).isIn(cartProductList)
        );
    }

    @And("{actor} should be able to finalize the purchase")
    public void heShouldBeAbleToFinalizeThePurchase(Actor actor) {
        actor.attemptsTo(
                Place.order(),
                WaitUntil.the(PURCHASE_CONFIRMATION, isVisible()).forNoMoreThan(ofSeconds(5))
        );
        String confirmationText = Text.of(PURCHASE_CONFIRMATION).answeredBy(actor);
        actor.attemptsTo(
                Ensure.that(confirmationText).isEqualTo("Thank you for your purchase!"),
                Click.on(PURCHASE_CONFIRMATION_BUTTON),
                Ensure.that(PURCHASE_CONFIRMATION).isNotDisplayed()
        );

    }

}
