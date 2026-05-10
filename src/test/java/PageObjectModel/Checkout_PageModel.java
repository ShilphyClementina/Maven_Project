package PageObjectModel;

import InterfaceElements.Checkout_InterfaceElements;
import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_PageModel extends Base_Class implements Checkout_InterfaceElements {

    @FindBy(xpath = cart_xpath)
    private static WebElement cart;

    @FindBy (xpath = placeord_xpath)
    private static WebElement placeOrd;


    public Checkout_PageModel() {
        PageFactory.initElements(driver,this);
    }

    public static void checkoutPage() throws InterruptedException {
       waitImplicitly(30);
        clickOnElement(cart);
        Thread.sleep(3000);
        takeScreenshot();
        clickOnElement(placeOrd);
    }
}
