package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {

    //uc test methodu yapin
    //1.method amazon.com
    //2.mmethod techproeducation
    //3.method facebook'a gitsin


    //eger her test methodu icin yeni bir sayfa acilsin ve test methodu sonunda kapansin
    //istiyorsak @Before ve @After kullanilmali
    static WebDriver driver;
    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void amazonTesti (){
        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    @Test
    public void techProTesti (){
        driver.get("https://www.techproed.com");

    }
    @Test
    public void facebookTesti (){
        driver.get("https://www.facebook.com");

    }

    @After
    public void tearDown () {
        driver.close();
    }

}
