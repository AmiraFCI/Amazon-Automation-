package TestCases;

import Pages.ForgetPasswordPage;
import Resources.JsonUtils;
import Utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Resources.JsonUtils.testdata;
public class ForgetPasswordTests extends TestBase{
    Helper helper=new Helper(driver);

    ForgetPasswordPage forgetPassword=new ForgetPasswordPage(driver);
    @Test
    public void validpasswordchanged()
    {
        forgetPassword.clickOnLogin();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(0).get("Phone").asText());
        forgetPassword.clickOnForgetPassword();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(0).get("Phone").asText());
        forgetPassword.continueBtn();
        forgetPassword.enterOTP(testdata.get("ForgotPassword").get(0).get("otp").asText());
       // note :the OTp changes every time
        forgetPassword.enterNpassword(testdata.get("ForgotPassword").get(0).get("newPassword").asText());
        forgetPassword.enterConfirmpassword(testdata.get("ForgotPassword").get(0).get("conPassword").asText());
        forgetPassword.clickSaveAbdLogin();
        Assert.assertEquals(helper.weclomemessagedisplayed(),true);


    }
    @Test
    public void InValidpasswordchangedwrongOTP()
    {
        forgetPassword.clickOnLogin();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(0).get("Phone").asText());
        forgetPassword.clickOnForgetPassword();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(0).get("Phone").asText());
        forgetPassword.continueBtn();
        forgetPassword.enterOTP(testdata.get("ForgotPassword").get(0).get("otp").asText());
        forgetPassword.continueBtn();
        Assert.assertTrue(helper.ErrorwithwrongOTP());

    }
    @Test
    public void InValidpasswordchangedwrongMismatchPassword()
    {
        forgetPassword.clickOnLogin();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(1).get("Phone").asText());
        forgetPassword.clickOnForgetPassword();
        forgetPassword.enterPhone(testdata.get("ForgotPassword").get(1).get("Phone").asText());
        forgetPassword.continueBtn();
        forgetPassword.enterOTP(testdata.get("ForgotPassword").get(1).get("otp").asText());
        // note :the OTp changes every time
        forgetPassword.enterNpassword(testdata.get("ForgotPassword").get(1).get("newPassword").asText());
        forgetPassword.enterConfirmpassword(testdata.get("ForgotPassword").get(1).get("conPassword").asText());
        forgetPassword.clickSaveAbdLogin();
        Assert.assertTrue(helper.ErrorwithMismatchPass());
    }
}
