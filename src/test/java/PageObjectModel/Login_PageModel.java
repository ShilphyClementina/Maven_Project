package PageObjectModel;

import InterfaceElements.Login_InterfaceElements;
import PageObjectManager.PageObjectManager;
import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 /*
    extends base class
    implements interfaceElements

    @FindBy --> Find element by
    constructor
    ActionsMethods
 */

public class Login_PageModel extends Base_Class implements Login_InterfaceElements {

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy (id = password_id)
    private static WebElement password;

    @FindBy (xpath = loginbtn_xpath)
    private static WebElement loginbtn;

    @FindBy (id = title_id)
    private static WebElement title;

    @FindBy(linkText = login_linkText)
    private static WebElement loginlink;

    //constructor
    public Login_PageModel(){
        PageFactory.initElements(driver,this);
    }

    public static void validLogin() throws InterruptedException {
        clickOnElement(loginlink);
        waitImplicitly(30);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
        clickOnElement(loginbtn);
        retrieveText(title);
        Thread.sleep(3000);
        takeScreenshot();
        Thread.sleep(3000);

    }


}
