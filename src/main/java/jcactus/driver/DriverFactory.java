/**
 * Код взят
 * http://defectracker.com/2019/08/02/instantiating-webdriver-with-driverfactory/
 *
 * Step 1: Create a DriverFactory class which instantiates WebDriver
 */
package jcactus.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        return getDriver(browser, false);
    }

    public static WebDriver getDriver(String browser, Boolean headless) {

        List<String> arguments = new ArrayList<>();
        WebDriver driver = null;

        if (headless.equals(true)) {
            arguments.add("--headless");
        }

        // Todo Добавить возможность запускать браузер в headless флагом

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (!arguments.isEmpty()) {
                    chromeOptions.addArguments(arguments);
                }
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (!arguments.isEmpty()) {
                    firefoxOptions.addArguments(arguments);
                }
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "opera":
                OperaOptions operaOptions = new OperaOptions();
                if (!arguments.isEmpty()) {
                    operaOptions.addArguments(arguments);
                }
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver(operaOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                // ToDo сделать запуск edge в headless
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                System.out.println("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        return driver;
    }
}
