package demoblaze;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"demoblaze.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@BuyTwoProducts"
)
public class RunnerBuyProduct {
}
