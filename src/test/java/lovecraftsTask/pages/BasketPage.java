package lovecraftsTask.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Vladyslav Vlasov on 24.01.2017.
 */
@DefaultUrl("http://www.loveknitting.com/checkout/cart/")
public class BasketPage extends PageObject {
    public static String pageURL = "http://www.loveknitting.com/checkout/cart/";

    @FindBy(how = How.XPATH, using = "//*[@id='shopping-cart-table']//*[@class='product-name']//a")
    WebElement shoppingCartTableProductLink;

    public BasketPage checkThatYouOnCorrectPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), pageURL);
        return this;
    }

    public BasketPage checkCorrectProductAddedOnBasketPage(String productName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(shoppingCartTableProductLink));
        Assert.assertTrue(shoppingCartTableProductLink.getText().contains(productName));
        return this;
    }

    public BasketPage closePopUpWindowIfPresent() {
        List list = findAll(By.xpath("//a[@title='Close']"));
        if (list.size() >= 1) {
            WebElement close = getDriver().findElement(By.xpath("//a[@title='Close']"));
            close.click();
        }
        return this;
    }
}
