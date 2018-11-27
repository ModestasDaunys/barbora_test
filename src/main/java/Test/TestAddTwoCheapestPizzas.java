package Test;

import LoginPage.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAddTwoCheapestPizzas {

    @Test
    public void addTwoPizzas() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        User user = new User(driver);

        user.goToPage("https://www.barbora.lt/");
        user.loginWithCredentials("test@test.com", "login123");
        user.closeModal();
        user.clearCart();
        user.clickOnButton("saldytas-maistas");
        user.clickOnButton("saldytos-picos-ir-uzkandziai");
        user.filterBy("priceAsc");
        user.addFirstAvailableProducts("2");
        driver.quit();
    }

}
