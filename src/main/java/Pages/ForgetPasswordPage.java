package Pages;

import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage  {

    WebDriver driver;
    Helper helper;
    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }
    By loginbtn=By.xpath("//a[contains(@class,'nav-progressive-attribute')]");
    By ForgetPasswordBtn=By.xpath("//a[@id='auth-fpp-link-bottom']");
    By  PhoneTextBox=By.xpath("//input[@id='ap_email']");
    By continueBtn=By.xpath("//input[@id='continue']");
    By OTP=By.xpath("//input[@id='input-box-otp']");
    By NewPassword=By.xpath("//input[@id='ap_fpp_password']");
    By ConfirmationPassword=By.xpath("//input[@id='ap_fpp_password_check']");
    By SaveAbdLogin=By.xpath("//input[@id='continue']");



    public void  clickOnLogin()
    {helper.click(loginbtn);}
    public void  clickOnForgetPassword() {
        helper.waitForVisible(ForgetPasswordBtn);
        helper.click(ForgetPasswordBtn);}
    public void enterPhone(String phone){
        helper.waitForVisible(PhoneTextBox);
        helper.type(PhoneTextBox,phone);}
    public void  continueBtn() {helper.click(continueBtn);}
    public void enterOTP(String Otp){
        helper.waitForVisible(OTP);
        helper.type(OTP,Otp);}
    public void enterNpassword(String newPassword){
        helper.waitForVisible(NewPassword);
        helper.type(NewPassword,newPassword);}
    public void enterConfirmpassword(String ConPassword){
        helper.type(ConfirmationPassword,ConPassword);}
    public void  clickSaveAbdLogin() {helper.click(SaveAbdLogin);}



}
