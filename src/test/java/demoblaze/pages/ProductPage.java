package demoblaze.pages;

import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.cssSelector;

public class ProductPage {

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart button")
            .located(cssSelector("a[class*='btn-success']"));


}
