package Practice.TestNG;

import org.testng.annotations.*;

public class Test001 {

    @BeforeSuite
    public void demo41(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void demo42(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void demo43(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void demo4(){
        System.out.println("Before Method");
    }

    @Test
    public void demo5(){
        System.out.println("Test 1");
    }

    @Test
    public void demo51(){
        System.out.println("Test 2");
    }

    @Test
    public void demo52(){
        System.out.println("Test 3");
    }

    @AfterMethod
    public void demo6() {
        System.out.println("After Method");
    }
}
