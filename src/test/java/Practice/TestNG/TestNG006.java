package Practice.TestNG;

import org.testng.annotations.Test;

public class TestNG006 {

    @Test(priority=1)
    public void T1(){
        System.out.println("A");
    }
    @Test(priority=-1)
    public void T2(){
        System.out.println("R");
    }
    @Test
    public void T3(){
        System.out.println("W");
    }
}
