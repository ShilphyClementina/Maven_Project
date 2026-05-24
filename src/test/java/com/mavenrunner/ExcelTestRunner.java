package com.mavenrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ReadExcelData;

public class ExcelTestRunner {

    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        //call method directly without extends keyword ReadExcelData.readParticularData
        String username = ReadExcelData.readParticularData(3,0);
        driver.findElement(By.name("email")).sendKeys(username);

        String password = ReadExcelData.readParticularData(3,1);
        driver.findElement(By.name("pass")).sendKeys(password);


    }
}
