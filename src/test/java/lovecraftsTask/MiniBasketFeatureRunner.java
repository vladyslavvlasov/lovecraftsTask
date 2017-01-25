package lovecraftsTask;

import cucumber.api.CucumberOptions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


/**
 * Created by Vladyslav Vlasov on 24.01.2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/MiniBasket.feature")
public class MiniBasketFeatureRunner {
}
