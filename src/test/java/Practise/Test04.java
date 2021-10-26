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
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

        // 5) CHART a gelin 3 ürün olduğunu doğrulayın
        WebElement yazi = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt_s  unvisible']"));
        Assert.assertTrue(yazi.isDisplayed());

        // 6) CHART'A GELiP Chek out TIKLAYIN
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        WebElement cart = driver.findElement(By.xpath("//body[@class='index hide-left-column hide-right-column lang_en']"));
        actions.moveToElement(cart).perform();
        Thread.sleep(5000);
      actions.click(driver.findElement(By.xpath("(//i[@class='icon-chevron-right right'])[1]")));
        System.out.println("buraya kadar geldim");


        // 7) toplam alışveriş miktarının 108.97 olduğunu doğrula

        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.PAGE_DOWN);
        System.out.println("buraya kadar geldim");
        WebElement price = driver.findElement(By.xpath("(//span[@id='total_price'])[1]"));
        System.out.println("price = " + price);
        Assert.assertTrue(price.getText().equals("108.97"));
        driver.close();
    }
}
