package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeNotasyonu {

    static WebDriver driver;
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

    // Amazon sayfasina gidip 3 farkli test method'u hazirlayin. Her method'da farkli aramalar yapalim.

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void test1() {

        searchBox.sendKeys("Nutella" + Keys.ENTER);
    }

    @Test
    public void test2() {

        searchBox.clear();
        searchBox.sendKeys("Bicycle" + Keys.ENTER);
    }

    @Test
    public void test3() {

        searchBox.clear();
        searchBox.sendKeys("JAVA" + Keys.ENTER);
    }

}
