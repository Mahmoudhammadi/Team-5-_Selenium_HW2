package amazon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHomePage extends BaseClass {
    @Test
    public void testBooksDeals() {
        WebElement deals= driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/a"));
        deals.click();
        WebElement daily2=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[1]/div/div/div/h1"));
        String actualDailyDeals=daily2.getText();
        String expectedDailyDeals = "Book Deals";

        Assert.assertEquals(actualDailyDeals, expectedDailyDeals, " LINKS DO NOT MATCH");
    }
    @Test
    public void testNewsStand(){
        WebElement news = driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[8]/span"));
        news.click();
        WebElement news2= driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[1]/div/h1/b"));

        String actualNews =news2.getText();
        String expectedNews="Kindle Newsstand";

        Assert.assertEquals(actualNews,expectedNews);


    }
    @Test
    public void kindleSingles(){
        WebElement singles = driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span"));
        singles.click();

        WebElement singles2=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[1]/table/tbody/tr/td/table/tbody/tr/td/img"));
        String actualSingles = singles2.getText();
        String expectedSingles= "";
        Assert.assertEquals(actualSingles,expectedSingles);
    }
    @Test
    public void buyKindleBook(){
        WebElement buy =driver.findElement(By.xpath("//*[@id='nav-subnav']/a[1]/span"));
        buy.click();

        WebElement buy2=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[1]/div/div[1]/div/div[1]/div/h1"));
        String actualBuy = buy2.getText();
        String expectedBuy= "Kindle";
    }
//    @Test
//    public void testManage(){
//        WebElement manage=driver.findElement(By.cssSelector("#nav-subnav > a:nth-child(9) > span"));
//        manage.click();
//        WebElement manage2= driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i"));
//        String actualManage = manage2.getText();
//        String expectedManage="";
//        Assert.assertEquals(actualManage,expectedManage);
//    }
//
//

    }

