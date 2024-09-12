package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='https://academybugs.com/store/dark-grey-jeans/'][@class='ec_image_link_cover']")
    WebElement darkGreyJeansLink;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnDarkGreyJeans() {
        darkGreyJeansLink.click();
    }
}
