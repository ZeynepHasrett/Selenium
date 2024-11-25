package day02_driverMethodlari_webElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
            Bir test otomasyonu icin
            ilk yapmamiz gereken sey bir WebDriver objesi edinmektir

            Selenium 4.12 surumuyle kendi WebDriver objesini olusturdu
            Boylece disaridan bir WebDriver tanimlamamiza gerek kalmadan
            Selenium WebDriver objesini kullanabilir ve
            testlerimizi yapabiliriz.

            Bazi sirketler acik kaynakli oldugu icin
            Selenium WebDriver kullanmamizi istemeyebilirler
            ve bize kullanmamiz icin bir WebDriver dosyasi verebilirler

            Eger sirkete ozel bir WebDriver objesi kullanilacaksa
            O WebDriver'i test class'imiza tanitmak icin
            System.setProperty() gereklidir

            AMA Selenium WebDriver kullanacaksak
            System.setProperty()'ye ihtiyac yoktur.
        */

        // System.setProperty("Webdriver.driver.chrome.driver", "kurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new FirefoxDriver();


        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        //   ve url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Youtube url testi PASSED");
        } else {
            System.out.println("Youtube url testi FAILED");
        }

        //3. Testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //   Title'in "Test Otomasyonu" icerdigini test edin

        //4. Tekrar YouTube'sayfasina donelim
        //5. Yeniden testotomasyonu sayfasina gidelim
        //6. Sayfayi Refresh(yenile) yapalim
        //7. Sayfayi kapatalim / Tum sayfalari kapatalim

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(3000);
        driver.quit();

    }

}
