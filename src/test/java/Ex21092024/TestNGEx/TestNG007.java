package Ex21092024.TestNGEx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {

    //in rela time, we avoid using priorities
    @Test (enabled = false)
    public void getToken(){
        Assert.assertTrue(true);
    }
    //This test case will always run irrespective of the fail of prior testcase
    @Test(alwaysRun = true, dependsOnMethods = "getToken")
    public void getBookingId(){
        Assert.assertTrue(true);
    }
    @Test ()
    public void put(){
        Assert.assertTrue(false);
    }
}
