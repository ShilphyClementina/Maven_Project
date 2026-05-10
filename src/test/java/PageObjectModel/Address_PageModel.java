package PageObjectModel;

import InterfaceElements.Address_InterfaceElements;
import PageObjectManager.PageObjectManager;
import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_PageModel extends Base_Class implements Address_InterfaceElements {

    @FindBy(xpath = name_xpath)
    private static WebElement name;

    @FindBy(xpath = country_xpath)
    private static WebElement country;

    @FindBy(xpath = city_xpath)
    private static WebElement city;

    @FindBy(xpath = card_xpath)
    private static WebElement card;

    @FindBy(xpath = month_xpath)
    private static WebElement month;

    @FindBy(xpath = year_xpath)
    private static WebElement year;

    @FindBy(xpath = purchase_xpath)
    private static WebElement purchase;

    @FindBy(xpath = thanks_xpath)
    private static WebElement thanks;

    @FindBy(xpath = ok_xpath)
    private static WebElement ok;

    @FindBy(xpath = logout_xpath)
    private static WebElement logout;

    @FindBy(css = total_css)
    private static WebElement total;


    public Address_PageModel() {
        PageFactory.initElements(driver, this);
    }

    public static void addressPage() throws InterruptedException {

        passInput(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
        passInput(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
        passInput(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
        passInput(card, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("card"));
        passInput(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
        passInput(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
        clickOnElement(purchase);
        Thread.sleep(3000);
        takeScreenshot();
        retrieveText(thanks);
        clickOnElement(ok);
        clickOnElement(logout);
        browserTermination();
    }
}
