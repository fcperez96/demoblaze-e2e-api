package demoblaze.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static demoblaze.pages.CartPage.*;
import static java.lang.String.valueOf;

public class Place {
    static Faker faker = new Faker();
    public static Performable order(){
        return Task.where("{0} place order",
                Click.on(PLACE_ORDER_BUTTON),
                Enter.theValue(faker.name().fullName()).into(ORDER_NAME),
                Enter.theValue(faker.name().fullName()).into(ORDER_NAME),
                Enter.theValue(faker.country().name()).into(ORDER_COUNTRY),
                Enter.theValue(faker.address().cityName()).into(ORDER_CITY),
                Enter.theValue(faker.business().creditCardNumber()).into(ORDER_CREDIT_CARD),
                Enter.theValue(valueOf(faker.date().birthday().getMonth())).into(ORDER_MONTH),
                Enter.theValue(valueOf(faker.date().birthday().getYear())).into(ORDER_YEAR),
                Click.on(PURCHASE_BUTTON)
        );
    }
}
