package PageObjectModel;

import InterfaceElements.Search_InterfaceElements;
import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_PageModel extends Base_Class implements Search_InterfaceElements {

    @FindBy(xpath = category_xpath)
    private static WebElement category;

    @FindBy(xpath = product_xpath)
    private static WebElement product;

    @FindBy(xpath = addtocart_xpath)
    private static WebElement addtoCart;


    public Search_PageModel() {
        PageFactory.initElements(driver, this);
    }

    public static void searchProduct() throws InterruptedException {
        waitImplicitly(30);
        clickOnElement(category);
        clickOnElement(product);
        clickOnElement(addtoCart);
        Thread.sleep(5000);
        getAlertText();
        alertActions("accept");



    }
}
