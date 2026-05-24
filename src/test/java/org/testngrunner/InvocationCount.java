package org.testngrunner;

import com.base.Base_Class;
import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class InvocationCount extends Base_Class {

//    @Test (invocationCount = 500)
//    public void name(){
//    System.out.println("Shilphy Clementina J");
//    }

    @Test (invocationCount = 2)
            public void login() {
        browserLaunch("chrome");
        launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        waitImplicitly(50);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        browserTermination();
    }

}
