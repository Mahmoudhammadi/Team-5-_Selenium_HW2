package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;

public class BaseClass {

    static String relativePath = "/resources/drivers/windows/chromedriver.exe";
    static String chromeDriverPath = System.getProperty("user.dir") + relativePath;
    static WebDriver driver;
    private final String URL = "https://www.amazon.com";


    @AfterMethod
    public void tearDown() throws InterruptedException {
        System.out.println("@AfterMethod");
        Thread.sleep(5000);
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
    public void robotClass() throws AWTException {
        Robot R1 = new Robot();
        R1.mouseWheel(4);

    }
 
}