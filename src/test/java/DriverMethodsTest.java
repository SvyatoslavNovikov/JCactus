/**
 * Код взят
 * http://defectracker.com/2019/08/02/instantiating-webdriver-with-driverfactory/
 */

import jcactus.driver.DriverMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverMethodsTest {

    WebDriver driver;

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