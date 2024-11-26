package day02_driverMethodlari_webElementKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_ByClassname {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfasına gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin

        // Kodlarimiz ile reel browser'daki bir webelement'i kullanabilmek icin
        // once o webelementi kodlarimizla tanimlayip
        // bir obje olarak class'da kaydetmeliyiz

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone");

        aramaKutusu.submit();

        // arama sonucunda urun bulunabildigini test edin

        // bulunan urunleri class attribute'u sayesinde toplu olarak locate edebiliyoruz

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi > 0) {
            System.out.println("Arama testi PASSED");
        } else System.out.println("Arama testi FAILED");

        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();

    }

}


