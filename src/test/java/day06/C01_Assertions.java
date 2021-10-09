package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {

    static WebDriver driver;

/*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak asagidaki testleri yapin.
    ○ Sayfa URL’inin https://www.bestbuy.com/ 'a esit oldugunu test edin.
    ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin.
    ○ logoTest => BestBuy logosunun görüntülendigini test edin.
    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin.
 */

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void urlTest() {

        String expectedURL = "https://www.bestbuy.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL Bulunamadi", expectedURL, actualURL);
    }

    @Test
    public void titleTest() {

        String istenmeyenKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse("Istenmeyen kelime Title'de var.", actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void logoTest() {

        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo görünmüyor.", logo.isDisplayed());
    }

    @Test
    public void francaisTest() {

        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue("Fransızca link görünmüyor.", francais.isDisplayed());
    }
}
