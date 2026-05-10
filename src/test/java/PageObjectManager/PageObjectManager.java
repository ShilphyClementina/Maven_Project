package PageObjectManager;

import PageObjectModel.Address_PageModel;
import PageObjectModel.Checkout_PageModel;
import PageObjectModel.Login_PageModel;
import PageObjectModel.Search_PageModel;
import utility.FileReaderManager;

public class PageObjectManager {

    private Login_PageModel loginPage;
    private FileReaderManager fileReader;
    private static PageObjectManager loginPageObjectManager;
    private static Search_PageModel searchPage;
    private static Checkout_PageModel checkoutPage;
    private static Address_PageModel addressPage;


    public static Address_PageModel getAddressPage() {
        if (addressPage == null){
            addressPage = new Address_PageModel();
        }
        return addressPage;
    }

    public static Checkout_PageModel getCheckoutPage() {
        if (checkoutPage == null){
            checkoutPage = new Checkout_PageModel();
        }
        return checkoutPage;
    }

    public static Search_PageModel getSearchPage() {
        if (searchPage == null){
            searchPage = new Search_PageModel();
        }
        return searchPage;
    }

    public Login_PageModel getLoginPage() {
        if (loginPage == null){
            loginPage = new Login_PageModel();
        }
        return loginPage;
    }
    public FileReaderManager getFileReader() {
        if (fileReader == null){
            fileReader = new FileReaderManager();
        }
        return fileReader;
    }
    public static PageObjectManager getPageObjectManager() {
        if (loginPageObjectManager == null){
            loginPageObjectManager = new PageObjectManager();
        }
        return loginPageObjectManager;
    }

}
