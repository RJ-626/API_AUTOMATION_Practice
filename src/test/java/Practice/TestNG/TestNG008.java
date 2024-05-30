package Practice.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG008 {
@Test
    void test1(){
    SoftAssert s= new SoftAssert();
        s.assertEquals(true,false,"true should not be equal to false");
        System.out.println("please execute it");
        s.assertAll();


        Assert.assertEquals(true,false,"failed");
    System.out.println("please do not execute");
    }


}
