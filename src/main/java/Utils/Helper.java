package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class Helper {



    private WebDriver driver;
    private WebDriverWait wait;
    By MisMatchPassMessage=By.xpath("//div[contains(text(),'Passwords must match')]");
    By WelcomeMessage=By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    By ErrorMessageOTP=By.xpath("//div[contains(text(),'Invalid OTP. Please check your code and try again.')]");

    By messagewithinvalidpaswword=By.xpath("//div[@class='a-alert-content']");

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean ErrorwithMismatchPass()
    {
      waitForVisible(MisMatchPassMessage);
        return isDisplayed(MisMatchPassMessage);
    }
    public Boolean ErrormessagedinvalidPassword()
    {   waitForVisible(messagewithinvalidpaswword);
        return isDisplayed(messagewithinvalidpaswword);
    }
    public Boolean weclomemessagedisplayed()
    {   waitForVisible(WelcomeMessage);
        return isDisplayed(WelcomeMessage);
    }

    public boolean ErrorwithwrongOTP()
    {
        waitForVisible(ErrorMessageOTP);
        return isDisplayed(ErrorMessageOTP);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    public void typeAndEnter(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
        el.sendKeys(Keys.ENTER);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
    }

    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void scrollIntoView(By locator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    public void switchToNewTab() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            if (!win.equals(currentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }




    }


    public void selectFirstOption(By locator) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByIndex(1); // index 0 is often "Select..." or "0 rooms"
    }

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public  void moveToElement(WebElement element) {
        {
            new Actions(driver).moveToElement(element);
        }
    }
    public  void moveAndClick(WebElement element) {
        {
            new Actions(driver).moveToElement(element).click().perform();
        }
    }

    public  String getShotAsBase64() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public File getShotAsFile(String shotName) {
        final String folder = "screenshots/";

        // Take screenshot using driver
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Timestamp to avoid overwriting
        String currentTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-S").format(new Date());

        File shot = new File(folder + shotName + "_" + currentTime + ".png");

        try {
            FileUtils.copyFile(scrFile, shot);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }

        return shot;
    }

}

