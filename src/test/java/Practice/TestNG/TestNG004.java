package Practice.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG004 {
    @BeforeTest
    public void T1(){
        System.out.println("1");
    }
    @BeforeTest
    public void T2(){
        System.out.println("2");
    }
    @Test
    public void T3(){
        System.out.println("3");
    }
}
