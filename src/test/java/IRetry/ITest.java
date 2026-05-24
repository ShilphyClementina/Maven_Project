package IRetry;

import com.base.Base_Class;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ITest extends Base_Class {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        browserLaunch("chrome");
        launchUrl("https://www.google.com/");
    }

    @Test(retryAnalyzer = ReTest.class)
    public void getTitle(){
        String pageTitle = Base_Class.getTitle_URL("title");
        Assert.assertEquals(pageTitle, "google" );
    }

    @AfterMethod
    public void afterMethod() {
        CloseBrowser();
    }

}