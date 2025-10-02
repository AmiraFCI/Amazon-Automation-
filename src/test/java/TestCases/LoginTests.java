package TestCases;

import Pages.LogInPage;
import Resources.JsonUtils;
import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Resources.JsonUtils.testdata;


public class LoginTests extends TestBase{
WebDriver driver;
    LogInPage login=new LogInPage(driver);
    Helper helper=new Helper(driver);


    @Test
    public void validlogin()
    {
       login.clickOnLogin();

       login.enterPhone(testdata.get("Login").get(0).get("Phone").asText());
       login.continueBtn();
       login.enterpassword(testdata.get("Login").get(0).get("password").asText());
       login.clickOnSignIn();
        Assert.assertEquals(helper.weclomemessagedisplayed(),true);



    }
    @Test
    public void invalidlogin()
    {
        login.clickOnLogin();
        login.enterPhone(testdata.get("Login").get(1).get("Phone").asText());
        login.continueBtn();
        login.enterpassword(testdata.get("Login").get(1).get("password").asText());
        login.clickOnSignIn();
     Assert.assertTrue(helper.ErrormessagedinvalidPassword());

    }
}
