package demoblaze.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;

public class PlaceOrderPage {

    public static final Target HOME_BUTTON = Target.the("home button").located(id("nava"));
    public static final Target LIST_OF_HOME_PRODUCTS = Target.the("product number {0}")
            .locatedBy("#tbodyid > div:nth-child({0}) > div > div a");
    public static final Target CART_BUTTON = Target.the("cart button").located(By.id("cartur"));
    public static final Target CATEGORIES = Target.the("categories section")
            .located(By.cssSelector("a#cat"));

}
