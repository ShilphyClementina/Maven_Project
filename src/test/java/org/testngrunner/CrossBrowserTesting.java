package org.testngrunner;

import com.base.Base_Class;
import org.testng.annotations.Test;

public class CrossBrowserTesting extends Base_Class {

    @Test
    public void chromeBrowser(){
        browserLaunch("chrome");
        launchUrl("https://www.wikipedia.org/");
        System.out.println("Chrome Browser Id: " + Thread.currentThread().getId());
    }

    @Test
    public void firefoxBrowser(){
        browserLaunch("firefox");
        launchUrl("https://www.wikipedia.org/");
        System.out.println("Firefox Browser Id: " + Thread.currentThread().getId());
    }

    @Test
    public void edgeBrowser(){
        browserLaunch("edge");
        launchUrl("https://www.wikipedia.org/");
        System.out.println("Edge Browser Id: " + Thread.currentThread().getId());
    }
}
