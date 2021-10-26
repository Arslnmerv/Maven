package Practise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class Test03 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// "http://automationpractice.com/" ADRESiNE GiDiP UYE OL.
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("deneme698@gmail.com"+ Keys.ENTER);
        driver.findElement(By.cssSelector("#id_gender1")).click();

        Faker faker = new Faker();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1950,2003)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.ENTER).perform();

        driver.close();
    }

    }


