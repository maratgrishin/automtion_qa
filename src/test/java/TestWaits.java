import lv.acodemy.constants.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaits {

    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @BeforeTest
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //implicitly wait
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // wait for loading page
    }

    @Test
    public void testWaiter() {
        driver.get(Generic.GOOGLE_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("element_that_is_not_in_place")));
        // driver.findElement(By.xpath("element_that_is_not_in_place"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
