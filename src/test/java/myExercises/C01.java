package myExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class C01 {

    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test
    public void test () {

        driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.TAB + "secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select= new Select(dropdown);
        select.selectByValue("lohi");
        WebElement lowestPricedItem = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
        //Assert.assertTrue("Prices didn't sorted from low to high!",select.getFirstSelectedOption().getText().equals(lowestPricedItem.getText()) );
        }



    @AfterClass
    public static void tearDown () {
        driver.close();

    }
}
