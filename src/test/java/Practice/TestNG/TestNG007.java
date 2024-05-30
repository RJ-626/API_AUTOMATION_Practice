package Practice.TestNG;

import org.testng.annotations.Test;

public class TestNG007 {

    @Test(groups= {"Sanity","QA","E2E"})
    public void SanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }
    @Test(groups= {"Sanity","regression","integration"})
    public void RegRun(){
        System.out.println("Regression");
        System.out.println("Sanity");
    }
    @Test(groups= {"Sanity","Smoke","Retest"})
    public void prodRun(){
        System.out.println("Sanity");
        System.out.println("Production");
    }

}
