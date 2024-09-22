package Ex21092024.TestNGEx;

import org.testng.annotations.Test;

public class TestNG005 {

    //in rela time, we avoid using priorities
    @Test (priority = 0)
    public void getToken(){
        System.out.println("3");
    }
    @Test(dependsOnMethods = "getToken")
    public void getBookingId(){
        System.out.println("1");
    }
    @Test (dependsOnMethods = "getBookingId")
    public void put(){
        System.out.println("2");
    }
}
