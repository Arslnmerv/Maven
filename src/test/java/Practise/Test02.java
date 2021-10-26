package Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {

        // 1) https://gmibank.com/ ADRESiNE GiDiN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gmibank.com/");

        // 2) Sign In BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//*[span='Sign in']")).click();

        // 3) Sign in EKRANINA GiTTiGiNiZi DOGRULAYIN
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://gmibank.com/login";

        if (driver.getCurrentUrl().equals(expectedUrl)) {
            System.out.println("URL Sign in Testi PASS");
        } else {
            System.out.println("URL Sign in Testi FAİLED");
        }

        Thread.sleep(5000);

        // 4) Sign in EKRANINA GiTTiGiNiZi FARKLI BiR WebElement'i KULLANARAK,2. KEZ DOGRULAYIN

        if ((driver.findElement(By.xpath("(//span[.='Sign in'])[2]")).getText()).equals("Sign in")) {
            System.out.println("URL Sign in Testi PASS");
        } else {
            System.out.println("URL Sign in Testi FAILED");
        }

        // 6) VERiLEN KULLANICI ADI VE SiFRE iLE SAYFAYA GiRiS YAPIN (Username: employee32, Password: team32team32-)

        WebElement username = driver.findElement(By.cssSelector("#username"));
        username.sendKeys("employee32", Keys.TAB);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("team32team32-", Keys.ENTER);

        // 5) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI DOGRULAYIN

        WebElement kullaniciGiris = driver.findElement(By.xpath("//span[text()='employee32 employee32']"));
        if (kullaniciGiris.isDisplayed()) {
            System.out.println("Kullanici giris1 testi PASS");
        } else {
            System.out.println("Kullanici giris1 testi FAILED");
        }
        // 6) VERiLEN KULLANICI iLE GiRiS YAPTIGINIZI FARKLI BiR WEBELEMENT'i KULLANARAK 2. KEZ DOGRULAYIN

        WebElement kullaniciGiris2 = driver.findElement(By.xpath("//span[text()='My Operations']"));
        if (kullaniciGiris2.isDisplayed()) {
            System.out.println("Kullanici giris2 testi PASS");
        } else {
            System.out.println("Kullanici giris2 testi FAILED");

            // 7) SAYFADAN CIKIS YAPIN

            kullaniciGiris.click();
            driver.findElement(By.className("svg-inline--fa fa-sign-out-alt fa-w-16 fa-fw ")).click();
            // 8) SAYFADAN CIKIS YAPILDIGINI DOGRULAYIN
            if ( driver.findElement(By.tagName("h2")).isDisplayed()){
                System.out.println("Test PASS");
            }else {
                System.out.println("Test Failed");
            }
            // 9) FARKLI BiR WEBELEMENT'i KULLANARAK, SAYFADAN CIKIS YAPILDIGINI 2. KEZ DOGRULAYIN

            driver.close();
        }
    }
}




