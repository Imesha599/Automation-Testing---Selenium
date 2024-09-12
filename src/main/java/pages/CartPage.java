package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    @FindBy(css = "[title='View Cart']")
    WebElement viewCartButton;

    @FindBy(css = ".ec_plus")
    WebElement plusButton;

    @FindBy(className = "ec_cartitem_update_button")
    WebElement updateItemSizeButton;

    @FindBy(id = "popmake-4406")
    WebElement popup;

    @FindBy(className = "academy-popup-bug-subtitle")
    WebElement bugTitleElement;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickViewCart() {
        viewCartButton.click();
    }

    public void increaseItemQuantity() {
        plusButton.click();
    }

    public void updateItemSize() {
        updateItemSizeButton.click();
    }

    public String getPopupBugTitle() {
        return bugTitleElement.getText();
    }

    public void removeFirstItemFromCart() {
    }
}
