package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {

/*
    1- https://www.amazon.com/ sayfasina gidelim.
    2- Arama kutusunu locate edelim.
    3- “Samsung headphones” ile arama yapalim.
    4- Bulunan sonuc sayisini yazdiralim.
    5- Ilk urunu tiklayalim.
    6- Sayfadaki tum basliklari yazdiralim.
 */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Class'in basinda implicitylWait komutu yazilirsa bu test boyunca her locator icin driver maximum yazilan kadar bekler.

        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        // WebElement sonucYazisiElementi = driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // By.className ile locate ettigimiz WebElement'inde class attribute'nin degerinde bosluk varsa locater saglikli calismayabilir.
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Sayisi : " + sonucYazisiElementi.getText());

        WebElement ilkUrunElementi = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
        // ilkUrunElementi.click();
        // Sadece bir click yapacaksak WebElement olusturmaya ve assign etmeye gerek yok. Direkt locate edip sonra click yapabiliriz.
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();

        driver.navigate().back();

        List <WebElement> urunlerListesi = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each: urunlerListesi) {
            System.out.println(each.getText());

        }

    }
}
