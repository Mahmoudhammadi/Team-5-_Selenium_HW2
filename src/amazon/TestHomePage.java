package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;

public class TestHomePage extends BaseClass {
    @Test (priority = 1)
    public void testAmazonHomePageLinks() {
        List<WebElement> linkslist = driver.findElements(By.tagName("a"));
        for (int i = 0; i < linkslist.size(); i++) {
            System.out.println(linkslist.get(i).getAttribute("href"));
        }
        System.out.println("Total number of links and " + "links list size is" + " " + linkslist.size());
    }
    @Test(priority = 2)
    public void testBestSellers() {
        WebElement BestSellers = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
        BestSellers.click();
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Amazon.com Best Sellers: The most popular items on Amazon";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Amazon Best Seller page doesn't match");
    }
    
    @Test(priority = 3)
    public void testScrollDownAction() throws AWTException {
        WebElement BestSellers = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[1]"));
        BestSellers.click();
        robotClass();
    }
    @Test(priority = 4)
    public void testBestSellerDepartmentList() throws AWTException {
    WebElement BestSellers = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[1]"));
        BestSellers.click();
        robotClass();
        List<WebElement>BestSellerDepartmentList= driver.findElements(By.xpath("//*[@id='zg_browseRoot']/ul"));
        String [] actualDepartmentList= new String[BestSellerDepartmentList.size()];
        for(int i=0; i< BestSellerDepartmentList.size(); i++){
            actualDepartmentList [i]= BestSellerDepartmentList.get(i).getText();
        }
        String [] expectedDepartmentList= {"Amazon Devices & Accessories", "Amazon Launchpad", "Appliances", "Apps & Games", "Arts, Crafts & Originals",
                "Automotive", "Baby", "Beauty & Personal Care", "Books", "CDs & Vinyl", "Camera & Photo", "Cell Phones & Accessories", "Clothing",
                "shoes & Jewelry", "Collectible & Currencies", "Computers & Accessories", "Digital Music", "Electronics", "Entertainment Collectibles",
                "Gifts Cards", "Grocery & Gourmet Food", "Handmade Products", "Health & Household", "Home & Kitchen", "Industrial & Scientific",
                "Kindle Store", "Kitchen Dining", "Magazine Subscriptions", "Movies & TV", "Musical Instruments", "Office Products", "Patio",
                "Lawn & Garden", "Pet Supplies", "Software", "Sports & Outdoors", "Sports Collectibles", "Tools & Home Improvement", "Toys & Games",
                "Video Games"};
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actualDepartmentList.length; i++){
            softAssert.assertEquals(actualDepartmentList[i], expectedDepartmentList[i],"Department NAME AT THE INDEX OF " + i + " DOES NOT MATCH");
        }
        softAssert.assertAll();
    }
    @Test(priority = 5)
    public void testBestSellerVideoGames() throws AWTException {
        WebElement BestSellers = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[1]"));
        BestSellers.click();
        robotClass();
        WebElement VideoGames= driver.findElement(By.xpath("//li[40]//a[1]"));
        VideoGames.click();
        WebElement BestSellerVideoGames= driver.findElement(By.xpath("//*[@id='zg-ordered-list']//li[1]"));
        BestSellerVideoGames.getText();
        System.out.println(BestSellerVideoGames.getText());
        
    }
    
}
