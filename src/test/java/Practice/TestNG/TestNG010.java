package Practice.TestNG;

import org.testng.annotations.Test;

public class TestNG010 {

    @Test
    public void serverstarted(){
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverstarted")
    public void method(){
        System.out.println("method");
    }
}
