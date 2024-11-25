package day01_WebDriverKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_WebDriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");
        // istenen url'e gider
        // url yazarken www yazmasak da Webdriver objesi url'e gider
        // ANCAK https: yazmazsak kod calismaz

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://testotomasyonu.com/

        System.out.println(driver.getPageSource()); // sayfa kaynak kodlarini getirir

        System.out.println(driver.getWindowHandle()); // C79C4BD4F7227A3A8D6B7B2957400806

        System.out.println(driver.getWindowHandles()); // [C79C4BD4F7227A3A8D6B7B2957400806]

        // WebDriver olusturulan her bir objeye
        // benzersiz(unique) bir Window Handle degeri atar

        // Eger bir class calistiginda birden fazla windows acilirsa
        // herbirinin ayri bir Window Handle degeri olur
        // getWindowHandle() driver'in actigi son window'un Window Handle degerini verir
        // getWindowHandles() ise acilan tum windows'larin tum Window Handle degerlerini bir Set olarak verir
        // driver'in acilan Window'lar arasinda gecis yapabilmesi icin
        // gececegi window'un Window Handle degerini bilmesi gerekir


        Thread.sleep(3000);

        driver.quit(); // actigimiz driver'i kapatir

        // driver.close(); // actigimiz driver'i kapatir
        // aralarindaki fark; close() sadece 1 window kapatir
        //                    quit() ise test sirasinda birden fazla window acilsa da hepsini kapatir

    }

}
