package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {

    WebDriver driver;

/*
    - 3 test method'u yapin.
    - 1. method --> https://www.amazon.com/
    - 2. method --> https://stackoverflow.com/
    - 3. metohd --> https://www.facebook.com/

    Eger her test method'u icin yeni bir sayfa acilsin ve test method'u sonunda kapansin istiyorsak @Before ve @After notasyonlari kullanilmalidir.
 */

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {

        driver.close();
    }

    @Test
    public void amazonTest() {

        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void stackoverflowTest() {

        driver.get("https://stackoverflow.com/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void facebookTest() {

        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
    }
}
