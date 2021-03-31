package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends BaseClass {




    @Test (priority = 1 , description = "test the burger menu on the amazon home page")
    public static void testBurgerMenu() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        driver.findElement(By.xpath("//a[@data-ref-tag='nav_em_1_1_1_6']")).click();
        driver.findElement(By.xpath("//*[@class='hmenu hmenu-visible hmenu-translateX']//a[text()='Prime Video']")).click();

        String actualResult=driver.findElement(By.xpath("//*[text()='Prime Video'][@class='av-retail-m-nav-text-logo']")).getText();
        String expectedResult="Prime Video";

        Assert.assertEquals(expectedResult,actualResult," Unexpected Result ");

    }


    @Test  (priority = 2 , description = " test the language on language using mouse over the element")
    public void testlanguageButton () throws InterruptedException {
        Actions action = new Actions(driver); // actions is a class that performs
        // all the mouse actions goind from a simple click to a right click and drop downs

        WebElement languageButton = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']"));

        action.moveToElement(languageButton).build().perform();
        WebElement spanish=driver.findElement(By.xpath("//*[@id=\"nav-flyout-icp\"]/div[2]/a[1]/span/i"));
        spanish.click();

        String actualResult= driver.findElement(By.xpath("//*[@id=\"glow-ingress-line1\"]")).getText();
        String expectedResult="Hola";

        Assert.assertEquals(actualResult,expectedResult,"Unmatched assertion");


    }

    @Test  (priority = 3 , description = " test the radio button of the language section ")
    public void testDropDown (){
        WebElement testdropdown = driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[2]"));
        boolean actualselectedlanguage=testdropdown.isSelected();
        boolean expectedselectedlanguage=true;
// this test wil fail
        Assert.assertEquals(actualselectedlanguage,expectedselectedlanguage,"unmatch value");

    }
    @Test   (priority = 4 , description = "test amazon home asserting with the title of the page")
    public void testAmazonHome(){
        // using the getTitle method to get the title of our webPage
        WebElement TestFindAGift = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[11]"));
        TestFindAGift.click();

        String title = driver.getTitle();

        String expectedTitle="Shop Amazon Home";
// using contains method for a string to avoid write the whole title
        // just a patial text of that title would be enough
        boolean actualtitlecontains = title.contains(expectedTitle);
        boolean expectresult=true;

        Assert.assertEquals(actualtitlecontains,expectresult,"Does not contain ");

    }
    @Test    (priority = 5 , description = "Scroll down to the Amazon music and test ")   
    public void testAmazonMusicFooter(){
        Actions actions = new Actions(driver);

        WebElement amazonMusic = driver.findElement(By.xpath("//*[@class=\"navFooterDescItem\"]/a[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).build().perform();

        amazonMusic.click();
        // using the getCurrentUrl method to get the url of the current page
        String expectUrl="https://music.amazon.com/?ref=dm_aff_amz_com";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectUrl,actualUrl,"Url Not Match");
    }

        //we have 2 type of closing for driver
        //first one is driver.close()  thqt close only the current session id of my driver
        //second one is driver.quit()


    }

