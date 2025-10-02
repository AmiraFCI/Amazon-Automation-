package TestCases;

import Resources.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.stream.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    private final String BASE_URL = "https://www.amazon.com/";

    @BeforeMethod
    public void setUp() {
        // Setup Chrome using WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

}}
