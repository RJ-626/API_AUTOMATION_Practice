package Practice.TestNG;

import org.testng.annotations.Test;

public class TestNG011 {

    @Test(groups={"init"})
    public void serverstarted(){
        System.out.println("I will run first");
    }

    @Test(groups = {"init"})
    public void initenv(){
        System.out.println("I will set the env");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void method(){
        System.out.println("method");
    }
}
