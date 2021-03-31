package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    static String relativePath = "/resources/drivers/mac/chromedriver";
    static String chromeDriverPath = System.getProperty("user.dir") + relativePath;
    static WebDriver driver;
    private final String URL = "https://www.amazon.com";



    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
        //driver.close();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    public static void setup() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","/Users/apple/IdeaProjects/SeleniumPractice_first/src/driver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("gloves");
//        driver.findElement(By.id("nav-search-submit-button")).click();
//
//        WebElement element=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]"));
//        String actual=element.getText();
//        Assert.assertEquals(actual,"\"gloves\"");
//        Thread.sleep(3000);
//        driver.close();
//    }
//
//    public static void main(String[] args)throws InterruptedException {
//        setup();
//    }

}
