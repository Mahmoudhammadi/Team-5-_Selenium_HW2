package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {

    static String relativePath = "/resources/drivers/mac/chromedriver";
    static String chromeDriverPath = System.getProperty("user.dir") + relativePath;
    static WebDriver driver;
    private final String URL = "https://www.amazon.com";



    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }



}
