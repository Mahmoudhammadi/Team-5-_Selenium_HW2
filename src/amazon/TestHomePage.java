package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends BaseClass {

    @Test
    public void testSearchBox () throws InterruptedException {
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Samsung S21 Ultra 5G");
        WebElement searchButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();
        Thread.sleep(5000);
    }
    @Test
    public void testAboutAmazonButton(){
        WebElement aboutAmazon = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a"));
        aboutAmazon.click();

    }
    @Test
    public void testAboutAmazonPage(){
        WebElement aboutAmazon = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a"));
        aboutAmazon.click();
       WebElement searchBox = driver.findElement(By.xpath("/html/body/header/div[2]/ps-header/div/div[2]/div[2]/div[1]/form/label/input"));
       searchBox.sendKeys("Do you guys need any Testers?!");
        WebElement searchButton = driver.findElement(By.xpath("/html/body/header/div[2]/ps-header/div/div[2]/div[2]/div[1]/form/span/svg"));
        searchButton.click();

    }
    @Test
    public void testAboutAmazonTitle(){
        WebElement aboutAmazon = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a"));
        aboutAmazon.click();
        String actualTitle = driver.getTitle().toLowerCase();
        String expectedTitle = "about amazon".toLowerCase();
        Assert.assertEquals(actualTitle, expectedTitle, "TITLE DOES NOT MATCH");
   ///html/body/div[1]/div/div/bsp-list-fast-facts-carousel/div/button[1]
    }
    @Test
    public void testSeeAllFactNextAndPrivButton() throws InterruptedException {
        WebElement aboutAmazon = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a"));
        aboutAmazon.click();
        WebElement seeAllFactNextButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/bsp-list-fast-facts-carousel/div/button[2]"));
        WebElement seeAllFactPreviousButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/bsp-list-fast-facts-carousel/div/button[1]"));
        Thread.sleep(3000);
        for (int i = 0 ; i<9 ; i++ ){
            seeAllFactNextButton.click();
        }
        Thread.sleep(3000);
        for (int i = 9 ; i>0 ; i-- ){
            seeAllFactPreviousButton.click();
        }
        Thread.sleep(3000);

    }



}
