package lovecraftsTask.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladyslav Vlasov on 24.01.2017.
 */
@DefaultUrl("http://www.loveknitting.com/paintbox-yarns-simply-aran")

public class PaintBoxYarnsSimpleAranPage extends PageObject {
    @cucumber.api.java.Before
    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static String paintBoxYarnsSimpleAranPageURL = "http://www.loveknitting.com/paintbox-yarns-simply-aran";

    @FindBy(how = How.ID, using = "attribute183")
    WebElement colorDropDown;
    @FindBy(how = How.ID, using = "quantity")
    WebElement quantityDropDown;
    @FindBy(how = How.ID, using = "add-to-cart")
    WebElement addToBasketButton;
    @FindBy(how = How.CLASS_NAME, using = "success-msg")
    WebElement confirmationMessage;
    @FindBy(how = How.ID, using = "j2t-closing-button")
    WebElement confirmationMessageCloseButton;


    public PaintBoxYarnsSimpleAranPage openPage() {
        getDriver().get(paintBoxYarnsSimpleAranPageURL);
        return this;
    }

    public PaintBoxYarnsSimpleAranPage checkThatYouOnCorrectPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), paintBoxYarnsSimpleAranPageURL);
        return this;
    }

    public PaintBoxYarnsSimpleAranPage selectColor(String color) {

        Select dropdown = new Select(colorDropDown);
        List<WebElement> dropdownOptions = colorDropDown.findElements(By.tagName("option"));
        for (WebElement option : dropdownOptions) {
            if (option.getText().contains(color)) {
                String fullElementText = option.getText();
                dropdown.selectByVisibleText(fullElementText);
                String rawXpath = "//option[contains(.,\'" + color + "\')]";
                $(rawXpath).click();
            }
        }

        return this;
    }

    public PaintBoxYarnsSimpleAranPage selectQuantity(int quantity) {

        String qtyStr = String.valueOf(quantity);
        Select dropdown = new Select(quantityDropDown);
        dropdown.selectByVisibleText(qtyStr);
        String rawXpath = "//option[contains(.,\'" + qtyStr + "\')]";
        $(rawXpath).click();
        return this;
    }

    public PaintBoxYarnsSimpleAranPage addToBasket() {
        waitFor(addToBasketButton);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(addToBasketButton).click().perform();
        return this;
    }

    public PaintBoxYarnsSimpleAranPage checkConfirmationMessage(String color, int quantity) {
        waitFor(confirmationMessage);
        String qtyStr = String.valueOf(quantity);
        Assert.assertTrue(confirmationMessage.getText().contains(color));
        Assert.assertTrue(confirmationMessage.getText().contains(qtyStr + " x"));
        return this;
    }

    public PaintBoxYarnsSimpleAranPage closeConfirmationMessage() {
        confirmationMessageCloseButton.click();
        return this;
    }

}
