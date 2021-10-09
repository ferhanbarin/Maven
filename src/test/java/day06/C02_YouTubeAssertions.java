package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_YouTubeAssertions {

    static WebDriver driver;

/*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin.
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin.
    ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin.
    ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin.
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin.
 */

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//*[.='Kabul ediyorum']")).click();
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void titleTest() {

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Sayfa title'i beklenenden farkli.", expectedTitle, actualTitle);
    }

    @Test
    public void logoTest() {

        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo görünmüyor.", logo.isDisplayed());
    }

    @Test
    public void searchBox() {

        WebElement searchBox = driver.findElement(By.id("search-input"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor.", searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {

        String expectedWrongTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals("Title istenmeyen kelimeye esit.", expectedWrongTitle, actualTitle);
    }
}
