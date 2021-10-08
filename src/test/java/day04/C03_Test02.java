package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {

/*
    1. http://zero.webappsecurity.com sayfasina gidin.
    2. Signin buttonuna tiklayin.
    3. Login alanina  “username” yazdirin.
    4. Password alanine “password” yazdirin.
    5. Sign in buttonuna tiklayin.
    6. Pay Bills sayfasina gidin.
    7. Amount kismina yatirmak istediginiz herhangi bir miktari yazin.
    8. Tarih kismina “2020-09-10” yazdirin.
    9. Pay buttonuna tiklayin.
    10. “The payment was successfully submitted.” mesajinin ciktigini control edin.
 */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com/"); // 1. http://zero.webappsecurity.com sayfasina gidin.

        driver.findElement(By.id("signin_button")).click(); // 2. Sign in buttonuna tiklayin.

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username"); // 3. Login alanine  "username" yazdirin.

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password"); // 4. Password alanine "password" yazdirin.

        driver.findElement(By.xpath("//input[@name='submit']")).click(); // 5. Sign in buttonuna tiklayin.

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click(); // 6. Pay Bills sayfasina gidin.
        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.id("sp_amount")).sendKeys("1000"); // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin.

        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10"); // 8. tarih kismina "2020-09-10" yazdirin.

        driver.findElement(By.id("pay_saved_payees")).click(); // 9. Pay buttonuna tiklayin.

        WebElement basariliYazisielementi=driver.findElement(By.id("alert_content")); // 10. "The payment was successfully submitted." mesajinin ciktigini control edin.

        if (basariliYazisielementi.isDisplayed()){
            System.out.println("Test PASS.");
        } else {
            System.out.println("Test FAILED.");
        }

    }
}
