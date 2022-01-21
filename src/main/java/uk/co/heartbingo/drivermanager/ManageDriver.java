package uk.co.heartbingo.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.propertyreader.PropertyReader;

import java.time.Duration;


public class ManageDriver {

    public static WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    

    public ManageDriver() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            /*ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--single-process");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("window-size=1280,800");
            options.setExperimentalOption("useAutomationExtension",false);
            options.setHeadless(false);
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});*/

           driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("window-size=1280,800");
            options.setHeadless(false);
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("window-size=1280,800");
            options.setHeadless(false);
            options.setExperimentalOption("useAutomationExtension",false);
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            driver = new EdgeDriver(options);
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
