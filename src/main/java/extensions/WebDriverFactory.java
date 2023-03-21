package extensions;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static config.AppConfig.MAIN_PAGE_URL;
import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;


public class WebDriverFactory {
    @Before
    public static WebDriver get() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String browserName = System.getenv().get("browser");
        WebDriver driver;
        switch (browserName) {
            case "chrome":

                driver = new ChromeDriver();
                // ChromeOptions options = new ChromeOptions();
                //driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default: throw new RuntimeException("Browser" + browserName + "not exist");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
        driver.navigate().to(MAIN_PAGE_URL);
        return driver;
    }
}
