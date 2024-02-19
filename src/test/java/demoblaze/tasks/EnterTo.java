package demoblaze.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static demoblaze.pages.PlaceOrderPage.CART_BUTTON;

public class EnterTo {
    public static Performable shoppingCart(){
        return Task.where("{0} enter to shopping cart",
                Click.on(CART_BUTTON)
        );
    }
}
