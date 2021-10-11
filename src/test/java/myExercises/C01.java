package myExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class C01 {


// (Each product cannot be added more then 1 time!)

// CHECK THE PRICES!
// Sum each item's price and compare your result with the website
// If results are matching print success message
// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
// Click Checkout

    static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://react-shopping-cart-67954.firebaseapp.com/");
    }


    @Test
    public void listeleme() {


       // List all the elements on the website
        List<WebElement> urunListesi = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        System.out.println(urunListesi.size());
        int sira = 1;
        for (WebElement each : urunListesi
        ) {
            System.out.println(sira + " " + each.getText());
            sira++;
        }
        // Create a String Arraylist and put Product Names into the ArrayList
        List<String> urunListesiArray = new ArrayList<>(urunListesi.size());
        for (WebElement each : urunListesi) {
            urunListesiArray.add(each.getText());
        }
        System.out.println(urunListesiArray);
    }
    @Test
    public void random () {

        //List<WebElement> random = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        List<WebElement> urunListesi = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));

        for (int i = 1; i <= 5; i++) {

            Math.random();
            //System.out.println(rad);


        }




        // Choose 5 items randomly, add to cart and print the names of items

    }
    }
//    @AfterClass
//    public static void tearDown () {
//        driver.close();
//
//    }
//}
