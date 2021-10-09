package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_YanlisEmailTesti {

    static WebDriver driver;

/*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim.
    3. Sign in butonuna basalim.
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim.
 */

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    @Test
    public void gecersizMailTesti() throws InterruptedException {

        driver.findElement(By.linkText("Sign in")).click();

        WebElement emailBox = driver.findElement(By.id("email_create"));
        emailBox.sendKeys("MerhabaFerhan" + Keys.ENTER);

        Thread.sleep(3000);

        WebElement alertBox = driver.findElement(By.id("create_account_error"));
        Assert.assertTrue("Uyari görünmedi.", alertBox.isDisplayed());
    }
}
