package org.testngrunner;

import org.testng.annotations.Test;

public class Grouping {

    @Test (groups = "ANIMAL")
    public void lion(){
        System.out.println("I am a Lion");
    }

    @Test (groups = "BIRD")
    public void pigeon(){
        System.out.println("I am a Pigeon");
    }

    @Test (groups = "TREES")
    public void appleTree(){
        System.out.println("I am a Apple Tree");
    }

    @Test (groups = "ANIMAL")
    public void dog(){
        System.out.println("I am a Dog");
    }

    @Test (groups = "BIRD")
    public void crow(){
        System.out.println("I am a Crow");
    }

    @Test (groups = "TREES")
    public void neemTree(){
        System.out.println("I am a Neem Tree");
    }
}
