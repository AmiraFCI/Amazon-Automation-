package Pages;

import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage  {
    WebDriver driver;
    Helper helper;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }

     By loginbtn=By.xpath("//a[contains(@class,'nav-progressive-attribute')]");
    By PhoneTextbox=By.xpath("//input[@id='ap_email_login']");
    By continueBtn=By.xpath("//input[@type='submit']");
    By PasswordTextbox=By.xpath("//input[@id='ap_password']");
    By signInbtn=By.xpath("//input[@id='signInSubmit']");



    public void  clickOnLogin() {helper.click(loginbtn);}
    public void enterPhone(String phone){
        helper.waitForVisible(PhoneTextbox);
        helper.type(PhoneTextbox,phone);}
    public void  continueBtn() {helper.click(continueBtn);}
    public void enterpassword(String password){helper.type(PasswordTextbox,password);}
    public void  clickOnSignIn() {helper.click(signInbtn);}


}
