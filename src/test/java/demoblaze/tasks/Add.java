package demoblaze.tasks;

import demoblaze.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;

import static demoblaze.pages.PlaceOrderPage.HOME_BUTTON;
import static demoblaze.pages.PlaceOrderPage.LIST_OF_HOME_PRODUCTS;
import static demoblaze.pages.ProductPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Add {
    public static Performable twoRandomProducts() {
        String randomProduct1 = String.valueOf((int) (Math.random() * 8) + 1);
        String randomProduct2;
        do {
            randomProduct2 = String.valueOf((int) (Math.random() * 8) + 1);
        } while (randomProduct1.equalsIgnoreCase(randomProduct2));

        theActorInTheSpotlight()
                .remember("productOneName", Text.of(LIST_OF_HOME_PRODUCTS.of(randomProduct1)));
        theActorInTheSpotlight()
                .remember("productTwoName", Text.of(LIST_OF_HOME_PRODUCTS.of(randomProduct2)));

        return Task.where("{0} add two random products in the cart",
                Click.on(LIST_OF_HOME_PRODUCTS.of(randomProduct1)),
                Click.on(ADD_TO_CART_BUTTON),
                Wait.forAlert(),
                Switch.toAlert().andAccept(),
                Click.on(HOME_BUTTON),
                Click.on(LIST_OF_HOME_PRODUCTS.of(randomProduct2)),
                Click.on(ADD_TO_CART_BUTTON),
                Wait.forAlert(),
                Switch.toAlert().andAccept()
        );
    }
}
