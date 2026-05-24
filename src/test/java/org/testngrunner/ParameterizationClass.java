package org.testngrunner;

import com.base.Base_Class;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationClass extends Base_Class {

    @Test
    @Parameters({"username", "password"})
    public void login(String username, String password){
        browserLaunch("chrome");
        launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        waitImplicitly(50);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        browserTermination();
    }
}
