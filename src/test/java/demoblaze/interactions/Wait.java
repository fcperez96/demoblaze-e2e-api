package demoblaze.interactions;

import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait {
    public static Interaction forAlert() {
        return instrumented(ForAlert.class);
    }
}
