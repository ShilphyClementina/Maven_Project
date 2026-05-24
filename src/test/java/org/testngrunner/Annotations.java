package org.testngrunner;

import org.testng.annotations.*;

public class Annotations {

    @BeforeSuite
    public void reportStart() {
        System.out.println("Execution report is started");
    }

    @BeforeTest
    public void browserLaunch() {
        System.out.println("Chrome Browser launched");
    }

    @BeforeClass
    public void launchAmazonurl() {
        System.out.println("Amazon URL launched");
    }

    @BeforeMethod
    public void login() {
        System.out.println("Logged in successfully");
    }

    @Test
    public void buyShoes() {
        System.out.println("Purchased shoes successfully");
    }

    @Test
    public void buyGrocery() {
        System.out.println("Purchased Groceries successfully");
    }

    @Test
    public void buyMedicines() {
        System.out.println("Purchased Medicines successfully");
    }

    @AfterMethod
    public void logout() {
        System.out.println("Logged out successfully");
    }

    @AfterClass
    public void closeAmazon() {
        System.out.println("Amazon application closed successfully");
    }

    @AfterTest
    public void generateReport() {
        System.out.println("Report generated successfully");
    }

    @AfterSuite
    public void browserTermination() {
        System.out.println("Browser Terminated successfully");
    }


}
