package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {

/*
    1- Test01 isimli bir class olusturun.
    2- https://www.walmart.com/ adresine gidin.
    3- Browseri tam sayfa yapin.
    4- Sayfayi “refresh” yapin.
    5- Sayfa basliginin “Save” ifadesi icerdigini control edin.
    6- Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz.
    7- URL in walmart.com icerdigini control edin.
    8-”Nutella” icin arama yapiniz.
    9- Kac sonuc bulundugunu yaziniz.
    10- Sayfayi kapatin.
 */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.walmart.com/");

        driver.navigate().refresh();

        String arananKelime = "Save";
        String actualTitle1 = driver.getTitle();

        if (actualTitle1.contains(arananKelime)) {
            System.out.println("Title " + arananKelime + " kelimesini iceriyor.\nTEST PASS.");
        } else {
            System.out.println("Title " + arananKelime + " kelimesini icermiyor.\nTEST FAILED..");
        }

        String expectedTitle = "Walmart.com | Save Money.Live Better";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle)) {
            System.out.println("Sayfa title beklenen ile ayni.\nTEST PASS.");
        } else {
            System.out.println("Sayfa title beklenen ile ayni degil.\nActual Title : " + actualTitle2);
        }

        String arananKelimeURL = "walmart.com";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(arananKelimeURL)) {
            System.out.println("URL " + arananKelimeURL + " kelimesini iceriyor.\nTEST PASS.");
        } else {
            System.out.println("URL " + arananKelimeURL + " kelimesini icermiyor.\nTEST FAILED.");
        }

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi.getText());

        driver.close();

    }
}
