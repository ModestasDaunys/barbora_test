package LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class User {

   public User(WebDriver driver) {

    this.driver=driver;
    }

    private WebDriver driver;

    public void goToPage (String page) {
        driver.get(page);
    }

    public void loginWithCredentials (String userEmail, String userPassword) {
        WebElement loginButton = driver.findElement(By.className("b-header--links--login"));
        loginButton.click();

        driver.findElement(By.id("b-login-email")).sendKeys(userEmail);
        driver.findElement(By.id("b-login-password")).sendKeys(userPassword);
        driver.findElement(By.className("b-login-form--login-button")).click();
        WebDriverWait wait = new WebDriverWait (driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));
    }

    public void closeModal() {
        boolean ModalIsDisplayed = driver.findElements(By.className("modal-content")).size() > 0;
        if (ModalIsDisplayed) {
            WebElement modalHeader = driver.findElement(By.className("b-zigzag-heading"));
            WebElement modalCloseButton = modalHeader.findElement(By.className("close"));
            modalCloseButton.click();
        }
    }

    public void clickOnButton(String hasURL) {
        driver.findElement(By.xpath("//a[contains(@href, '"+hasURL+"')]")).click();
    }

    public void filterBy (String filterValue) {
        Select filter = new Select(driver.findElement(By.className("b-orderby")));
        filter.selectByValue(filterValue);
    }


    public void addFirstAvailableProducts(String productQuantity) {

        List<WebElement> products =  driver.findElements(By.className("b-product--desktop-grid"));
        for (WebElement product : products) {
            boolean isDisplayed = product.findElement(By.className("b-quantity-select--input")).isDisplayed();
            if (isDisplayed){
                WebElement cheapestProductQuantityInput = product.findElement(By.className("b-quantity-select--input"));
                cheapestProductQuantityInput.clear();
                cheapestProductQuantityInput.sendKeys(productQuantity);
                product.findElement(By.className("b-add-to-cart")).click();
                break;
            }
        }

    }

    public void clearCart () {
        boolean isEmptyCart = driver.findElements(By.className("b-sidebar-cart-empty")).size() > 0;
        if (isEmptyCart) {
            System.out.println("Cart is empty!");
        } else {
            List <WebElement> cartItems = driver.findElements(By.className("b-cart--item"));
            for (WebElement cartItem : cartItems) {
                WebElement cartItemCloseBlock = cartItem.findElement(By.className("b-cart-item--actions"));
                cartItemCloseBlock.findElement(By.className("c-btn")).click();
            }
        }
    }
}

