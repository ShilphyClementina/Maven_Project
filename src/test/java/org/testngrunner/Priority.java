package org.testngrunner;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 0)
    public void adult(){
        System.out.println("Adult");
    }

    @Test(priority = 3)
    public void seniorCitizen(){
        System.out.println("Senior Citizen");
    }

    @Test(priority = -4)
    public void newBorn(){
        System.out.println("New Born");
    }

    @Test(priority = -2)
    public void teenager(){
        System.out.println("Teenager");
    }

    @Test(priority = -2)
    public void infant(){
        System.out.println("Infant");
    }
}
