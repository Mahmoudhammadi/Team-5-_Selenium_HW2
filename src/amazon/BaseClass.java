package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseClass {

    static String relativePath = "/resources/drivers/mac/chromedriver";
    static String chromeDriverPath = System.getProperty("user.dir") + relativePath;
    static WebDriver driver;
    private final String URL = "https://www.amazon.com";




    //@AfterMethod
    @AfterSuite
    public void tearDown() {
        System.out.println("@AfterMethod");
        driver.close();
        driver.quit();
    }

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        System.out.println("@BeforeMethod");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void testBooksButton() throws InterruptedException {
        WebElement kindelBooksButton = driver.findElement(By.xpath("//a[normalize-space()='Kindle Books']"));
        kindelBooksButton.click();
        Thread.sleep(3000);

        WebElement element=driver.findElement(By.xpath("//*[@id='a-page']/div[2]/div[2]/div[1]/div[1]/table/tbody/tr/td/table/tbody/tr/td/img"));
        String actual=element.getText();
        Assert.assertEquals("",actual);

}}
