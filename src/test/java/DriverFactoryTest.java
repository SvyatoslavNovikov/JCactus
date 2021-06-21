/**
 * Код взят
 * http://defectracker.com/2019/08/02/instantiating-webdriver-with-driverfactory/
 */

import jcactus.driver.DriverFactory;
import jcactus.driver.DriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    WebDriver driver;

    @Test
    public void testSystemChromeDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryDefault() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver();
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryChrome() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("chrome");
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryFirefox() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("firefox");
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryOpera() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("opera");
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    //ToDo Проблемы при запуске edge
//    @Test
//    public void testDriverFactoryEdge() throws InterruptedException {
//        DriverFactory obj = new DriverFactory() {};
//        jcactus.driver = obj.getDriver("edge");
//        jcactus.driver.get("http://www.google.co.in");
//        synchronized (jcactus.driver) { jcactus.driver.wait(2000); }
//    }

    @Test
    public void testDriverFactoryChromeHeadless() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("chrome", true);
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryFirefoxHeadless() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("firefox", true);
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverFactoryOperaHeadless() throws InterruptedException {
        DriverFactory obj = new DriverFactory() {};
        driver = obj.getDriver("opera", true);
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverMethodsDefault() throws InterruptedException {
        DriverMethods obj = new DriverMethods();
        driver = obj.driver;
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverMethodsChrome() throws InterruptedException {
        DriverMethods obj = new DriverMethods("chrome");
        driver = obj.driver;
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverMethodsFirefox() throws InterruptedException {
        DriverMethods obj = new DriverMethods("firefox");
        driver = obj.driver;
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    @Test
    public void testDriverMethodsOpera() throws InterruptedException {
        DriverMethods obj = new DriverMethods("opera");
        driver = obj.driver;
        driver.get("http://www.google.co.in");
        synchronized (driver) { driver.wait(2000); }
    }

    //ToDo Проблемы при запуске edge
//    @Test
//    public void testDriverMethodsEdge() throws InterruptedException {
//        DriverMethods obj = new DriverMethods("edge");
//        jcactus.driver = obj.jcactus.driver;
//        jcactus.driver.get("http://www.google.co.in");
//        synchronized (jcactus.driver) { jcactus.driver.wait(2000); }
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
