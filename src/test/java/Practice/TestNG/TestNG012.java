package Practice.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG012 {

    @Parameters("Browser")
    @Test(priority = 1)
    public void T1(String value){
        System.out.println("Browser is "+value);
    }
}
