package TestCases;

import Pages.HomPage;
import Pages.LogInPage;
import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    WebDriver driver;
    HomPage home=new HomPage(driver);
    Helper helper=new Helper(driver);
    @Test
    public void verifytoysPageTitle()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();
        Assert.assertTrue(home.ToysTitledisplay());
    }
    @Test
    public void verifypricedisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();
        home.openToyItem();
        Assert.assertTrue(home.priceisdisplay());


    }


    @Test
    public void Reviewsisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();
        home.openToyItem();
        Assert.assertTrue(home.Reviewsisdisplay());

    }
    @Test
    public void NewArrivelisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();
        Assert.assertTrue(home.ToysnewArrivalisplay());

    }
    @Test
    public void bestSellerdisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();

        Assert.assertTrue(home.ToysBestSellerisplay());

    }
    @Test
    public void descriptionisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();

    }
    @Test
    public void productrelateddisplayed()
    {
        home.clickOnAllCategory();
        home.seeAllBtn();
        home.clickTOysandGameCategory();
        home.clickTOysandGamePage();
        home.openToyItem();
        Assert.assertTrue(home.relatedProductisdisplay());

    }

}
