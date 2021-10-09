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

public class C06_Test {

    static WebDriver driver;
/*
    1- Test01 isimli bir class olusturun.
    2- https://www.amazon.com/ adresine gidin.
    3- Browseri tam sayfa yapin.
    4- Sayfayi "refresh" yapin.
    5- Sayfa basliginin "Amazon" ifadesi icerdigini control edin.
    6- Sayfa basliginin "Amazon.com. Spend less. Smile more." a esit oldugunu control ediniz.
    7- URL'nin amazon.com icerdigini control edin.
    8- "Nutella" icin arama yapiniz.
    9- Kac sonuc bulundugunu yaziniz.
    10- Sayfayi kapatin.
 */
    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().refresh();

    }

    @After
    public void tearDown() {

        driver.close();
    }

    @Test
    public void webTest() {

        driver.get("https://www.amazon.com/");

        String expectedTitle1 = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle1)) {
            System.out.println("Sayfa basligi 'Amazon' ifadesi iceriyor.\nTEST PASS.");
        } else {
            System.out.println("Sayfa basligi 'Amazon' ifadesi icermiyor.\nTEST FAILED.");
        }

        String expectedTitle2 = "Amazon.com. Spend less. Smile more.";

        if (actualTitle.equals(expectedTitle2)) {
            System.out.println("Sayfa basligi 'Amazon.com. Spend less. Smile more.' esit.\nTEST PASS.");
        } else {
            System.out.println("Sayfa basligi 'Amazon.com. Spend less. Smile more.' esit.\nTEST FAILED.");
        }

        String expectedURL = "amazon.com";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)) {
            System.out.println("URL 'amazon.com' iceriyor.\nTEST PASS.");
        } else {
            System.out.println("URL 'amazon.com' icermiyor.\nTEST FAILED.");
        }

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Nutella" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(result.getText() + " for Nutella");

    }
}

