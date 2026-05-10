package com.runner;

import PageObjectManager.PageObjectManager;
import com.base.Base_Class;

import java.awt.*;

public class TestRunner extends Base_Class {

    public static void main(String[] args) throws AWTException, InterruptedException {
        browserLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().searchProduct();
        PageObjectManager.getPageObjectManager().getCheckoutPage().checkoutPage();
        PageObjectManager.getPageObjectManager().getAddressPage().addressPage();

    }
}
