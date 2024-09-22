package Ex21092024.TestNGEx;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {

    //in rela time, we avoid using priorities
    @Test (priority = 0)
    public void getToken(){
        System.out.println("3");
    }
    @Test(priority = 7)
    public void getBookingId(){
        System.out.println("1");
    }
    @Test (priority = 10)
    public void put(){
        System.out.println("2");
    }
}
