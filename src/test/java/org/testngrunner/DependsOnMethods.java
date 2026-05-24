package org.testngrunner;

import org.testng.annotations.Test;

public class DependsOnMethods {

//    @Test
//    public void a_login(){
//        System.out.println("Logged in successfully");
//    }
//
//    @Test
//    public void b_addToCart(){
//        System.out.println("Product added to cart successfully");
//    }
//
//    @Test (dependsOnMethods = {"a_login", "b_addToCart"})
//    public void payment(){
//        System.out.println("Payment completed successfully");
//    }

    @Test
    public void methodOne(){
        int i = 5;
        System.out.println(i/0);
    }

    @Test
    public void methodTwo(){
        System.out.println("Method Two executed successfully");
    }

    @Test (dependsOnMethods = {"methodTwo","methodOne"})
    public void methodThree(){
        System.out.println("Method Three executed successfully");
    }
}
