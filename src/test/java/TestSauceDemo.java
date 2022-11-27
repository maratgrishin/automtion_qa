import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static lv.acodemy.constants.Generic.SAUCE_URL;

public class TestSauceDemo {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.get(SAUCE_URL);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }


    @Test
    public void authorizeTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getTitleElement().getText(), "PRODUCTS");
    }

    @Test
    public void openProductTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        inventoryPage.clickOnProductByLabel("Sauce Labs Bolt T-Shirt");
        System.out.println();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
