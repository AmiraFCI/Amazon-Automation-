package Pages;

import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage  {
    WebDriver driver;
    Helper helper;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }


    By clickOnCreation = By.xpath("//a[@aria-label='New to Amazon? Start here to create an account']");
    By PhoneTextbox = By.xpath("//input[@id='ap_email_login']");
    By ProccedtoCreatebtn = By.xpath("//input[@type='submit']");
    By PhoneForm = By.xpath("//input[@id='ap_phone_number']");
    By UserName = By.xpath("//input[@id='ap_customer_name']");

    By PasswordTextbox = By.xpath("(//input[@id='ap_password'])[1]");
    By PasswordConfirm = By.xpath("//input[@id='ap_password_check']");
    By verifyNum = By.xpath("//input[@id='continue']");

 By OTPTextBox=By.xpath("//input[@id='cvf-input-code']");
 By CreateAccount=By.className("//input[@aria-label='Verify OTP Button']");
   By passswordconstrains=By.xpath("//div[@id='auth-password-invalid-password-alert']");

    public void MoveandClick() {
        WebElement element = driver.findElement(clickOnCreation);
        helper.moveAndClick(element);
    }

    public void enterPhone(String phone) {
        helper.waitForVisible(PhoneTextbox);
        helper.type(PhoneTextbox, phone);

    }

    public void ProccedtoCreate() {
        helper.click(ProccedtoCreatebtn);
    }


    public void addphone(String phony) {
        helper.waitForVisible(PhoneForm);
        helper.type(PhoneForm, phony);
    }

    public void addusername(String user) {
        helper.type(UserName, user);
    }

    public void addpassword(String password){
        helper.type(PasswordTextbox,password);
}
    public void addConfirmpassword(String Confpassword){
        helper.type(PasswordConfirm,Confpassword);
    }


    public void clickOnCreationbtn() {
        helper.click(verifyNum);
    }

    public boolean ErrorwithPassConstrains()
    {
        helper.waitForVisible(passswordconstrains);
        return helper.isDisplayed(passswordconstrains);
    }
    public void addOTP(String OTP){
        helper.waitForVisible(CreateAccount);
        helper.type(OTPTextBox,OTP);
    }
    public void OnCreationbtn() {

        helper.click(CreateAccount);
    }

}