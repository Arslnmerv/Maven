package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_YanlisEmailTesti {
//    1.Bir Class olusturalim YanlisEmailTesti

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        //2.http://automationpractice.com/index.php sayfasina gidelim
    }


    @Test
    public void emailClickTest() throws InterruptedException {
        //3.Sign in butonuna basalim
        //4.Email kutusuna @isareti olmayan bir mail yazip
        // enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        driver.findElement(By.linkText("Sign in")).click();
        WebElement emailGirisKutusu = driver.findElement(By.id("email_create"));
        emailGirisKutusu.sendKeys("merhaba televole" + Keys.ENTER);

        Thread.sleep(2000);
        WebElement hataYazisiElementi = driver.findElement(By.xpath("//li[text()='Invalid email address.']"));

        Assert.assertTrue("Mesaj gorunmedi", hataYazisiElementi.isDisplayed());


    }

    @After
    public void tearDown() {
        driver.close();
    }
}