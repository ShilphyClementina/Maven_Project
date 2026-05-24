package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Base_Class {

    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static File file;

    protected static WebDriver browserLaunch(String browserName) {

        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING BROWSER LAUNCH");
        }
        driver.manage().window().maximize();
        return driver;
    }

    protected static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING LAUNCH URL");
        }
    }

    protected static void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING CLICKING ELEMENT");
        }
    }

    protected static void passInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING PASSING INPUT");
        }
    }

    protected static void browserTermination() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING BROWSER TERMINATION ");
        }
    }

    protected static void CloseBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING BROWSER CLOSING ");
        }
    }

    protected static void windowsHandling(int number) {
        try {
            List<String> allwindow = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(allwindow.get(number));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING WINDOWS HANDLING");
        }
    }

    protected static void selectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        select.isMultiple();
        List<WebElement> options = select.getOptions();
        for (WebElement getAllOptions : options) {
            System.out.println(getAllOptions);
        }
        try {
            if (type.equalsIgnoreCase("TEXT")) {
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("VALUE")) {
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("INDEX")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("VALUE")) {
                WebElement firstselect = select.getFirstSelectedOption();
                System.out.println(firstselect.getText());
            } else if (type.equalsIgnoreCase("TEXT")) {
                for (WebElement allselectopts : select.getAllSelectedOptions()) {
                    System.out.println("Selected option is : " + allselectopts.getText());
                }
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SELECTING OPTIONS");
        }
    }

    protected static void deSelectOptions(WebElement element, String type, String value) {
        Select select = new Select(element);
        select.isMultiple();

        try {
            if (type.equalsIgnoreCase("TEXT")) {
                select.deselectByValue(value);
            } else if (type.equalsIgnoreCase("VALUE")) {
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("INDEX")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("VALUE")) {
                select.deselectAll();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SELECTING OPTIONS");
        }
    }

    protected static void navigateToUrl(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING NAVIGATING TO URL");
        }
    }

    protected static void browserNavigation(String type) {
        try {
            if (type.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (type.equalsIgnoreCase("forward")) {
                driver.navigate().forward();
            } else if (type.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING BROWSER NAVIGATION");
        }
    }

    protected static void alertActions(String type) {
        Alert alert = driver.switchTo().alert();
        try {
            if (type.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (type.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING ALERT ACTIONS");
        }
    }

    protected static void sendValuesAlert(String value) {
        Alert alert = driver.switchTo().alert();
        try {
            alert.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED WHILE GETTING TEXT IN ALERT");
        }
    }

    protected static void getAlertText() {
        Alert alert = driver.switchTo().alert();
        try {
            String text = alert.getText();
            System.out.println("The text in the alert box is : " + text);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED WHILE GETTING TEXT IN ALERT");
        }
    }

    protected static void elementVerification(WebElement element, String type) {
        try {
            if (type.equalsIgnoreCase("enabled")) {
                element.isEnabled();
            } else if (type.equalsIgnoreCase("displayed")) {
                element.isDisplayed();
            } else if (type.equalsIgnoreCase("selected")) {
                element.isSelected();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING ELEMENT VERIFICATION");
        }

    }

    protected static String getTitle_URL(String value) {
        try {
            if (value.equalsIgnoreCase("title")) {
                driver.getTitle();
            } else if (value.equalsIgnoreCase("current url")) {
                driver.getCurrentUrl();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING PAGE TITLE OR CURRENT URL RETRIEVAL");
        }

        return value;
    }

    protected static void retrieveText(WebElement element) {
        try {
            String text = element.getText();
            System.out.println(text);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING CURRENT URL RETRIEVAL");
        }
    }

    protected static void waitImplicitly(int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING WAITING IMPLICITLY");
        }
    }

    protected static void waitExplicitly(int seconds, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(seconds)));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING WAITING IMPLICITLY");
        }
    }

    protected static void takeScreenshot() {
        try {
            Date currentDate = new Date();
            String datereplace = currentDate.toString().replace(" ", "_").replace(":", "_");
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("D:\\Shilphy\\Testing\\Automation testing - Greens technologies\\Work Space\\IPT_Java_Project\\Screenshots\\" + datereplace + ".png"));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED WHILE TAKING SCREENSHOT ");
        }
    }

    protected static void javascriptExecutor(WebElement element, String type, String sendValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            if (type.equalsIgnoreCase("click")) {
                js.executeScript("arguments[0].click();", element);
            } else if (type.equalsIgnoreCase("pass value")) {
                js.executeScript("arguments[0].value=arguments[1];", element, sendValue);
            } else if (type.equalsIgnoreCase("scrollIntoView")) {
                js.executeScript("arguments[0].scrollIntoView();", element);
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED IN JAVA SCRIPT EXECUTOR");
        }
    }

    protected static void jsScrollUp(int h, int v) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.scrollBy(" + h + "," + v + ")");
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SCROLLING UP OR DOWN");
        }
    }

    protected static void performActions(WebElement element, String type) {
        Actions act = new Actions(driver);
        try {
            if (type.equalsIgnoreCase("moveToElement")) {
                act.moveToElement(element).perform();
            } else if (type.equalsIgnoreCase("contextClick")) {
                act.contextClick(element).perform();
            } else if (type.equalsIgnoreCase("doubleClick")) {
                act.doubleClick(element).perform();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED WHILE PERFORMING ACTIONS");
        }
    }

    protected static void dragAndDrop(WebElement elementA, WebElement elementB) {
        Actions act = new Actions(driver);
        try {
            act.dragAndDrop(elementA, elementB).perform();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING DRAG AND DROP");
        }
    }

    protected static void framesHandling(String type, WebElement element, String value) {
        try {
            if (type.equalsIgnoreCase("id")) {
                driver.switchTo().frame(value);
            } else if (type.equalsIgnoreCase("index")) {
                driver.switchTo().frame(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("WebElement")) {
                driver.switchTo().frame(element);
            } else if (type.equalsIgnoreCase("parent")) {
                driver.switchTo().parentFrame();
            } else if (type.equalsIgnoreCase("default")) {
                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING FRAMES HANDLING");
        }
    }

    protected static void robot(int function) throws AWTException {
        Robot r = new Robot();
        try {
            r.keyPress(function);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING Key Press function ");
        }
    }

    protected static void extentReportStart(String location) {
        try {
            extentReports = new ExtentReports();
            file = new File(location);
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        }catch (Exception e){
            Assert.fail("ERROR: OCCURRED DURING ");
        }
    }

    protected static void extentReportTearDown(String location) throws IOException {
        try {
            extentReports.flush();
            file = new File(location);
            Desktop.getDesktop().browse((file).toURI());
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING ");
        }
    }

    protected String takeScreenshot3() throws IOException{
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
            File destfile = new File("D:\\Shilphy\\Testing\\Automation testing - Greens technologies\\Work Space\\IPT_Java_Project\\Screenshots\\" + timestamp + ".png");
            FileHandler.copy(scrfile, destfile);
            return destfile.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}