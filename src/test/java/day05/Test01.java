package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Test01 {
    //    1-Test01 isimli bir class olusturun

    static WebDriver driver;

    @Before
    public void setup() {
        //2- https://www.amazon.com/ adresine gidin
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
    }

    @Test
    public void test1() {
        //5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin

        if (driver.getTitle().contains("Amazon")) {
            System.out.println("Test1 PASS!");
        } else {
            System.out.println("Test1 FAILED!");
        }
    }

    @Test
    public void test2() {
        //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz

        if (driver.getTitle().equals("Amazon.com. Spend less. Smile more.")) {
            System.out.println("Test2 PASS!");
        } else {
            System.out.println("Test2 FAILED!");
        }

    }

    @Test
    public void test3() {
        //7- URL in amazon.com icerdigini control edin

        if (driver.getCurrentUrl().contains("amazon.com")) {
            System.out.println("Test3 PASS!");
        } else {
            System.out.println("Test3 FAILED!");
        }
    }

    @Test
    public void test4() {
        //8-”Nutella” icin arama yapiniz
        //9- Kac sonuc bulundugunu yaziniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        WebElement results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(results.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
