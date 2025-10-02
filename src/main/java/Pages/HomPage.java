package Pages;

import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomPage {
    Helper helper;
    WebDriver driver;
    public HomPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }
    By AllCategorybtn= By.xpath("//a[@id='nav-hamburger-menu']");
    By seeAllbtn=By.xpath("//div[normalize-space()='See all']");
    By ToysandGame=By.xpath("(//a[@role='button'])[16]");
    By TOysAndGamePage=By.xpath("//a[normalize-space()='All Toys & Games']");
   By ToysTitle=By.xpath("//b[normalize-space()='Toys']");
  By NewArrival=By.xpath("//span[normalize-space()='Toys & Games New Arrivals']");
By bestSeller=By.xpath("//span[normalize-space()='Toys & Games | Best Sellers']");
By toyItem=By.xpath("//img[contains(@alt, \"Baby Toys\")");
By price=By.xpath("//span[@class='a-price-symbol']");
By reviews=By.xpath("//span[@id='acrCustomerReviewText']");
By relatedProduct=By.xpath("//div[@id='sp_detail_heading']");

    public void  clickOnAllCategory() {
        helper.click(AllCategorybtn);
    }
    public void seeAllBtn( ){
        helper.click(seeAllbtn);
    }
    public void clickTOysandGameCategory()
    {
        helper.scrollIntoView(ToysandGame);
        helper.click(ToysandGame);
    }
    public void clickTOysandGamePage()
    {
        helper.scrollIntoView(TOysAndGamePage);
        helper.click(TOysAndGamePage);
    }
    public boolean ToysTitledisplay(){
        helper.waitForVisible(ToysTitle);
        return helper.isDisplayed(ToysTitle);

    }
    public boolean ToysBestSellerisplay(){
       helper.scrollIntoView(bestSeller);
        return helper.isDisplayed(bestSeller);

    }
    public boolean ToysnewArrivalisplay(){
        helper.scrollIntoView(NewArrival);
        return helper.isDisplayed(NewArrival);

    }
public void openToyItem()
{
    helper.scrollIntoView(toyItem);
    helper.click(toyItem);

}
    public boolean  Reviewsisdisplay(){

        helper.waitForVisible(reviews);
        return helper.isDisplayed(reviews);

    }
    public boolean  priceisdisplay(){
          helper.waitForVisible(price);
        return helper.isDisplayed(price);

    }
    public boolean relatedProductisdisplay(){
        helper.waitForVisible(relatedProduct);
        return helper.isDisplayed(relatedProduct);

    }

}
