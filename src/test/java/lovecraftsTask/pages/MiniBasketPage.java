package lovecraftsTask.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Created by Vladyslav Vlasov on 25.01.2017.
 */
public class MiniBasketPage extends PageObject {

    @FindBy(how = How.CLASS_NAME, using = "icon-basket")
    WebElement miniBasket;
    @FindBy(how = How.CLASS_NAME, using = "basket-dropdown")
    WebElement basketDropDown;
    @FindBy(how = How.XPATH, using = "//*[@class='basket-dropdown']//h2[@class='product-name']//a")
    WebElement basketDropDownLink;
    @FindBy(how = How.XPATH, using = "//*[@class='basket-dropdown']//a[contains(text(), 'Go to Basket')]")
    WebElement goToBasketButton;

    public MiniBasketPage clickOnMiniBasket() {
        miniBasket.click();
        return this;
    }

    public MiniBasketPage checkCorrectMiniBasketInfo(String product) {
        Assert.assertTrue(basketDropDownLink.getText().contains(product));
        return this;
    }

    public MiniBasketPage clickGoToBasket() {
        goToBasketButton.click();
        return this;
    }

}
