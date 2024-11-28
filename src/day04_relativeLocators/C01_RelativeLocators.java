package day04_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");


        // 1. olarak MOTOR E13-Aurora Green solunda diye relative locator kullanalim

        // 2 ) DSLR Camera’yi etrafindaki elementleri kullanarak
        // 3 farkli relative locator ile locate edip tiklayin

        // 1- Relative Locator'i kullanmak icin oncelikle
        //    hedef webelemente ait bir ozelligi bulmamiz gerekir
        //    bunun icin locate edecek gibi webelementi inceleyelim
        //    <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
        //      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
        //      <span>DSLR Camera</span></a>

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Sayfayi asagiya kaydirmak icin

        // 2- Hedef webelementin etrafinda kullanabildigimiz bir webelementi
        //    locate edip kaydedelim
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        // 3- Artik Relative locator elementi locate edip kaydedebiliriz
        driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon))
                .click();

        // 3 ) Acilan urunun DSLR Camera oldugunu test edin.
        WebElement urunIsımElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsımElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("Dslr camera 1. Test PASSED");
        } else System.out.println("Dslr camera 1. Test FAILED");

        Thread.sleep(1000);


        // 2. olarak Apple kulakligin saginda diye relative locator kullanalim
        driver.get("https://testotomasyonu.com/relativeLocators");

        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Sayfayi asagiya kaydirmak icin

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklik))
                .click();

        urunIsımElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        expectedUrunIsmi = "DSLR Camera";
        actualUrunIsmi = urunIsımElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("Dslr camera 2. Test PASSED");
        } else System.out.println("Dslr camera 2. Test FAILED");


        // 3. olarak Bat Rockerz 510 Bluetooth Heads'in altinda diye relative locator kullanalim
        driver.get("https://testotomasyonu.com/relativeLocators");

        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Sayfayi asagiya kaydirmak icin

        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik))
                .click();

        urunIsımElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        expectedUrunIsmi = "DSLR Camera";
        actualUrunIsmi = urunIsımElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("Dslr camera 3. Test PASSED");
        } else System.out.println("Dslr camera 3. Test FAILED");

        Thread.sleep(3000);
        driver.quit();

    }

}
