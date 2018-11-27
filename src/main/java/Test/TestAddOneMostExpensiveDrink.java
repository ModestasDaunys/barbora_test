package Test;

import User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAddOneMostExpensiveDrink {

    @Test
    public void addOneMostExpensiveDrink() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        User user = new User(driver);

        user.goToPage("https://www.barbora.lt/");
        user.loginWithCredentials("test@test.com", "login123");
        user.closeModal();
        user.clearCart();
        user.clickOnButton("gerimai");
        user.clickOnButton("gazuoti-vaisvandeniai");
        user.filterBy("priceDesc");
        user.addFirstAvailableProducts("1");
        driver.quit();
    }

}
