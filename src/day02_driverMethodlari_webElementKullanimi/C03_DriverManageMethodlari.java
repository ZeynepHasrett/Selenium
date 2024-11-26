package day02_driverMethodlari_webElementKullanimi;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // HTML kodlarin daha erisilebilir olmasi icin
        // her class'in basina mutlaka maximize yapariz
        driver.get("https://www.testotomasyonu.com");

        // acilista window size ve konumunu yazdirin
        System.out.println("Acilista boyut : " + driver.manage().window().getSize());
        System.out.println("Acilista konum : " + driver.manage().window().getPosition());

        // window'u maximize yapin
        driver.manage().window().maximize();

        // maximize yaptigimizda window size ve konumunu yazdirin
        System.out.println("Maximize boyut : " + driver.manage().window().getSize());
        System.out.println("Maximize konum : " + driver.manage().window().getPosition());

        // window'u fullscreen yapin
        driver.manage().window().fullscreen();

        // fullscreen yaptigimizda window size ve konumunu yazdirin
        System.out.println("Fullscreen boyut : " + driver.manage().window().getSize());
        System.out.println("Fullscreen konum : " + driver.manage().window().getPosition());

        // istedigimiz konum ve boyuta getirelim
        driver.manage().window().setSize(new Dimension(500, 500));
        driver.manage().window().setPosition(new Point(100, 100));

        // istedigimiz boyutta iken window size ve konumunu yazdirin
        System.out.println("Istedigimiz boyutta boyut : " + driver.manage().window().getSize());
        System.out.println("Istedigimiz boyutta konum : " + driver.manage().window().getPosition());

        Thread.sleep(2000);
        driver.quit();

    }

}
