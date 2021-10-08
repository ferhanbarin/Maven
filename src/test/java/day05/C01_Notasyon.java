package day05;

import org.junit.Test;

public class C01_Notasyon {

    // JAVA'daki gibi Selenium'da da belirli islevleri yapan method'lar olusturabiliriz. Ancak bu method'lar cagrilmadikca CALISMAZLAR.
    public void ilkTestMethod() {

        System.out.println("Ilk test method.");
    }

    // JUnit ilk notasyon kullanarak siradan method'lari test method'una dönüstürebiliriz. Bir Test Method'u bagimsiz olarak calisabilen test yapmamiza imkan verir.
    // @Test notasyonu sayesinde MAIN METHOD mecburiyeti ortadan kalkar.
    @Test
    public void notasyonluIlkTestMethod() {

        System.out.println("Notasyonlu ilk test method.");
    }
}
