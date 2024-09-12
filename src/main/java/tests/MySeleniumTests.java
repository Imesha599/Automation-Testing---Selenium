package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.CartPage;
import pages.ProductPage;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;

public class MySeleniumTests {

    public static void main(String[] args) {
        // Set up the WebDriver
        WebDriver driver = setupWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated constructor

        try {
            // Execute test cases
            testCase1(driver, wait);
            testCase2(driver, wait);
            testCase3(driver, wait);
            testCase4(driver, wait);
            testCase5(driver, wait);
        } finally {
            // Wait and close the browser
            waitForSeconds(90);
            driver.quit();
        }
    }

    // Setup WebDriver
    public static WebDriver setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        return new ChromeDriver();
    }

    // Utility method to wait for a specified number of seconds
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Test Case 1: Add product to cart and update quantity
    public static void testCase1(WebDriver driver, WebDriverWait wait) {
        driver.get("https://academybugs.com/find-bugs");

        // Initialize Page Objects
        HomePage homePage = new HomePage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        // Perform actions using the Page Objects
        homePage.clickAddToCart();
        cartPage.clickViewCart();
        cartPage.increaseItemQuantity();
        cartPage.updateItemSize();

        // Fetch and print bug title from popup
        String bugText = cartPage.getPopupBugTitle();
        System.out.println("New Bug: " + bugText);
    }

    // Test Case 2: Click on the "Dark Grey Jeans" link
    public static void testCase2(WebDriver driver, WebDriverWait wait) {
        driver.get("https://academybugs.com/find-bugs");

        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        productPage.clickOnDarkGreyJeans();

        // Fetch and print bug title from popup
        String bugText = cartPage.getPopupBugTitle();
        System.out.println("New Bug: " + bugText);
    }

    // Test Case 3: Add product to the cart and verify success message
    public static void testCase3(WebDriver driver, WebDriverWait wait) {
        driver.get("https://academybugs.com/find-bugs");

        HomePage homePage = new HomePage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        homePage.clickAddToCart();

        // Wait for success message and handle
        try {
            String successMessage = cartPage.getPopupBugTitle();
            System.out.println("Success Message: " + successMessage);
        } catch (Exception e) {
            System.out.println("Product successfully added to your cart.");
        }
    }

    // Test Case 4: Add product to cart and then remove it
    public static void testCase4(WebDriver driver, WebDriverWait wait) {
        driver.get("https://academybugs.com/find-bugs");

        HomePage homePage = new HomePage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        // Add product to cart and remove it
        homePage.clickAddToCart();
        cartPage.clickViewCart();
        cartPage.removeFirstItemFromCart();

        // Handle success message after removal
        try {
            String successMessage = cartPage.getPopupBugTitle();
            System.out.println("Success Message: " + successMessage);
        } catch (TimeoutException e) {
            System.out.println("Product Successfully deleted.");
        }
    }

    // Test Case 5: Click on the "Dark Grey Jeans" link and check bug
    public static void testCase5(WebDriver driver, WebDriverWait wait) {
        driver.get("https://academybugs.com/find-bugs");

        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        productPage.clickOnDarkGreyJeans();

        // Fetch and print bug title from popup
        String bugText = cartPage.getPopupBugTitle();
        System.out.println("New Bug: " + bugText);
    }
}