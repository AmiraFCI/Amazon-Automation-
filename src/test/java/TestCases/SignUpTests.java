package TestCases;

import Pages.SignUpPage;
import Resources.JsonUtils;
import Utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Resources.JsonUtils.testdata;

public class SignUpTests extends TestBase{
    Helper helper=new Helper(driver);
    SignUpPage signup=new SignUpPage(driver);

    @Test
    public void validSignUp()
    {
        signup.MoveandClick();
        signup.enterPhone(testdata.get("SignUp").get(0).get("phone").asText());
        signup.ProccedtoCreate();
        signup.addphone(testdata.get("SignUp").get(0).get("phone").asText());
        signup.addusername(testdata.get("SignUp").get(0).get("name").asText());
        signup.addpassword(testdata.get("SignUp").get(0).get("password").asText());
        signup.addConfirmpassword(testdata.get("SignUp").get(0).get("conPassword").asText());
        signup.clickOnCreationbtn();
        //note Otp change on every time so can't assert it
    }
    @Test
    public void invalidSignUpMismatchPassAndCOnfirmPass()
    {
        signup.MoveandClick();
        signup.enterPhone(testdata.get("SignUp").get(1).get("phone").asText());
        signup.ProccedtoCreate();
        signup.addphone(testdata.get("SignUp").get(1).get("phone").asText());
        signup.addusername(testdata.get("SignUp").get(1).get("name").asText());
        signup.addpassword(testdata.get("SignUp").get(1).get("password").asText());
        signup.addConfirmpassword(testdata.get("SignUp").get(1).get("conPassword").asText());
        signup.clickOnCreationbtn();
        Assert.assertTrue(helper.ErrorwithMismatchPass());
    }
    @Test
    public void invalidSignUpMismatchPassConstrains()
    {
        signup.MoveandClick();
        signup.enterPhone(testdata.get("SignUp").get(2).get("phone").asText());
        signup.ProccedtoCreate();
        signup.addphone(testdata.get("SignUp").get(2).get("phone").asText());
        signup.addusername(testdata.get("SignUp").get(2).get("name").asText());
        signup.addpassword(testdata.get("SignUp").get(2).get("password").asText());
        signup.addConfirmpassword(testdata.get("SignUp").get(2).get("conPassword").asText());
        signup.clickOnCreationbtn();
        Assert.assertTrue(signup.ErrorwithPassConstrains());

    }

    @Test
    public void invalidSignUpWrongOTP()
    {
        signup.MoveandClick();
        signup.enterPhone(testdata.get("SignUp").get(2).get("phone").asText());
        signup.ProccedtoCreate();
        signup.addphone(testdata.get("SignUp").get(2).get("phone").asText());
        signup.addusername(testdata.get("SignUp").get(2).get("name").asText());
        signup.addpassword(testdata.get("SignUp").get(2).get("password").asText());
        signup.addConfirmpassword(testdata.get("SignUp").get(2).get("conPassword").asText());
        signup.clickOnCreationbtn();
        signup.addOTP(testdata.get("SignUp").get(2).get("OTP").asText());
        signup.OnCreationbtn();
        Assert.assertTrue(helper.ErrorwithwrongOTP());

    }




}
