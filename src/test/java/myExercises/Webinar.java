package myExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Webinar {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.jotform.com/form/212804571037350");

        Thread.sleep(2000);
        WebElement name = driver.findElement(By.id("first_3"));
        name.sendKeys("Merve");

        Thread.sleep(2000);
        WebElement surname = driver.findElement(By.id("last_3"));
        surname.sendKeys("Melek");

        Thread.sleep(2000);
        WebElement email = driver.findElement(By.id("input_4"));
        email.sendKeys("arslan34@gmail.com");

        driver.findElement(By.cssSelector("#input_8_area")).sendKeys("+90");

        WebElement telNo = driver.findElement(By.name("q8_isTelefonu[phone]"));
        telNo.sendKeys("12345687896");

        driver.findElement(By.id("input_5")).sendKeys("Techpro");

        WebElement country = driver.findElement(By.xpath("//select[@id='input_7_country']"));
        country.click();
        country.sendKeys("Andorra");
        country.click();

        driver.findElement(By.xpath("//button[@id='input_2']")).submit();
        Thread.sleep(2000);

        driver.quit();
    }
}
