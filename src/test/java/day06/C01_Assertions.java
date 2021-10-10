package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {

//    1) Bir class oluşturun: BestBuyAssertions

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/ ");

        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    }


    @Test
    public void urlTest() {
        String expectedURL = "https://www.bestbuy.com/";
        String actualURl = driver.getCurrentUrl();

        Assert.assertEquals("Istenen URL bulunamadi", expectedURL, actualURl);
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

    }

    @Test
    public void titleTest() {
        String istenmeyenKelime = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse("istenmeyen kelime title da var ", actualTitle.contains(istenmeyenKelime));
       // ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin

    }

    @Test
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("logo gorunmuyor", logo.isDisplayed());
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin


    }
    @Test
    public void fransizcaTesti () {
        WebElement fransizca= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue("fransizca gorunmuyor" , fransizca.isDisplayed());



        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}


