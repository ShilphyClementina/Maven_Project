package listener;

import com.aventstack.extentreports.ExtentTest;
import com.base.Base_Class;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ExtentReport_Test extends Base_Class {

    public static ExtentTest extenttest;

    @BeforeSuite
    public void extentTestReportStartup() throws IOException{
        Base_Class base = new Base_Class() {
        };
        base.extentReportStart(null);
    }

    @AfterSuite
    public void extentReportEnd() throws IOException{
        Base_Class base = new Base_Class() {
        };
        base.extentReportTearDown(null);
    }
}
