package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Homework {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);
        //    1. “https://www.saucedemo.com” Adresine gidin

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        userNameBox.sendKeys("standard_user");
        Thread.sleep(500);
        //2. Username kutusuna “standard_user” yazdirin

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(500);
        //3. Password kutusuna “secret_sauce” yazdirin

        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        //4. Login tusuna basin

        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
        Thread.sleep(2000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        //6. Add to Cart butonuna basin

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        //7. Alisveris sepetine tiklayin

        String productOfBasket = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
        String firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();

        if (productOfBasket.equals(firstProduct)) {
            System.out.println("Test PASS!");
        } else {
            System.out.println("Test FAILED!");
        }
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        driver.quit();
        //9. Sayfayi kapatin
    }


}
