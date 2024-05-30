package Practice.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {

    String token;
    Integer BookingId;

    public String getToken(){
        token="123as";
        return token;
    }
    @BeforeTest
    public void GetBooking(){
        token=getToken();
        BookingId=456;
    }
    @Test
    public void PutReq(){
        System.out.println(token);
        System.out.println(BookingId);
    }
    @Test
    public void PutReq2(){
        System.out.println(token);
        System.out.println(BookingId);
    }
    @Test
    public void PutReq3(){
        System.out.println(token);
        System.out.println(BookingId);
    }
}
