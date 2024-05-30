package Practice.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG009 {
    @Test
    public void T01(){
        Assert.assertEquals(true,false,"failed");
        System.out.println("please do not execute");

    }

    @Test
    public void T02(){
        Assert.assertEquals(true,false,"failed");
        System.out.println("please do not execute");

    }
}
