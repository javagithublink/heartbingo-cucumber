package uk.co.heartbingo.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.propertyreader.PropertyReader;

import java.time.Duration;


public class ManageDriver {

    public static WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    private static final Logger log = LogManager.getLogger(ManageDriver.class.getName());

    public ManageDriver() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertiesfile/log4j2.properties");
    }



    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            log.info("Initiating "+ browser + "browser");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            log.info("Initiating "+ browser + "browser");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            log.info("Initiating "+ browser + "browser");
            WebDriverManager.edgedriver().setup();
           driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
        }
    }
}
