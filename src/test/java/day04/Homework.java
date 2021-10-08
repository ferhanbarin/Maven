package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework {

/*
    1. "https://www.saucedemo.com" Adresine gidin.
    2. Username kutusuna "standard_user" yazdirin.
    3. Password kutusuna "secret_sauce" yazdirin.
    4. Login tusuna basin.
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin.
    6. Add to Cart butonuna basin.
    7. Alisveris sepetine tiklayin.
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin.
    9. Sayfayi kapatin.
 */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/"); // "https://www.saucedemo.com" adresine gidin.

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // Username kutusuna "standard_user" yazdirin.
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce"); // Password kutusuna "secret_sauce" yazdirin.
        driver.findElement(By.id("login-button")).click(); // Login tusuna basin.

        WebElement ilkUrunKayit = driver.findElement(By.xpath("//div[@class='inventory_item_name']")); // Ilk urunun sayfasina gidin.
        String ilkUrun = ilkUrunKayit.getText(); // Ilk urunun ismini kaydedin.
        ilkUrunKayit.click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // Add to Cart butonuna basin.

        driver.findElement(By.id("shopping_cart_container")).click(); // Alisveris sepetine tiklayin.

        WebElement sepet = driver.findElement(By.id("item_4_title_link"));

        if (sepet.isDisplayed()) {
            System.out.println("Urun basarili olarak sepete eklendi.\nTEST PASSED.");
        } else {
            System.out.println("Urun sepete eklenemedi.\nTEST FAILED.");
        }

        driver.close();

    }
}
