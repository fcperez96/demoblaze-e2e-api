package demoblaze.pages;

import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class CartPage {
    public static final Target CART_PRODUCT_LIST = Target.the("cart product list")
            .located(xpath("//tbody[@id='tbodyid']/tr/td[2]"));
    public static final Target PLACE_ORDER_BUTTON = Target.the("place order button")
            .located(cssSelector("button.btn.btn-success"));
    public static final Target ORDER_NAME = Target.the("order name")
            .located(cssSelector("input#name"));
    public static final Target ORDER_COUNTRY = Target.the("order country")
            .located(cssSelector("input#country"));
    public static final Target ORDER_CITY = Target.the("order city")
            .located(cssSelector("input#city"));
    public static final Target ORDER_CREDIT_CARD = Target.the("order credit card")
            .located(cssSelector("input#card"));
    public static final Target ORDER_MONTH = Target.the("order month")
            .located(cssSelector("input#month"));
    public static final Target ORDER_YEAR = Target.the("order year")
            .located(cssSelector("input#year"));
    public static final Target PURCHASE_BUTTON = Target.the("purchase button")
            .located(cssSelector("button[onclick*='purchaseOrder']"));
    public static final Target PURCHASE_CONFIRMATION = Target.the("purchase confirmation")
            .located(cssSelector("div.sa-icon.sa-custom + h2"));
    public static final Target PURCHASE_CONFIRMATION_BUTTON = Target.the("purchase confirmation button")
            .located(cssSelector("button.confirm.btn.btn-lg.btn-primary"));

}
