package Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // 1) "http://automationpractice.com/" ADRESiNE GiDiN
        driver.get("http://automationpractice.com/");

        // 2) 2. URUNUN UZERiNE GELiP Add to chart YAPIN
        Actions actions = new Actions(driver);
        WebElement ikinciUrun = driver.findElement(By.xpath("(//a[@class='product-name'])[2]"));
        actions.moveToElement(ikinciUrun).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

        // 3) 4. URUNUN UZERiNE GELiP Add to chart YAPIN
        WebElement dorduncuUrun = driver.findElement(By.xpath("(//a[@class='product-name'])[4]"));
        actions.moveToElement(dorduncuUrun).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[4]")).click();
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

        // 4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN
        WebElement besinciUrun = driver.findElement(By.xpath("(//a[@class='product-name'])[5]"));
        actions.moveToElement(besinciUrun).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[5]")).click();
        ///driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        Thread.sleep(2000);
        
        // 5) CHART a gelin 3 ürün olduğunu doğrulayın
        WebElement yazi = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt_s  unvisible']"));
        Assert.assertTrue(yazi.isDisplayed());

        // 6) CHART'A GELiP Chek out TIKLAYIN
        WebElement chart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        actions.moveToElement(chart).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Check out']")).click();
        //actions.click(driver.findElement(By.xpath("(//i[@class='icon-chevron-right right'])[1]")));
        Thread.sleep(2000);
        
        // 7) toplam alışveriş miktarının 108.97 olduğunu doğrula
        WebElement totalPrice = driver.findElement(By.xpath("//span[@id='total_price']"));
        String actualPrice = totalPrice.getText();
        String expectedPrice = "$108.97";

        System.out.println("ALISVERiS TOPLAMI : " + totalPrice.getText());
        Assert.assertTrue(actualPrice.contains("108.97"));
        
      driver.close();
    }
}
