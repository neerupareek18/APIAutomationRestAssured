package Ex21092024.Assertions;

import APIChaining_Assignment21092024.RestFulBooker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftHardAssertions_ParametersNotFetching {

    @Test
    public void TC001(){
        String name = null;
        Assert.assertNotNull(name);
        System.out.println("This line will not be executed -- Hard Assertion");
    }

    @Test
    public void TC002(){
        String name = "Neeru Pareek";
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(false);
        System.out.println("This line will be executed even after failed assertion -- Soft Assertion");

        RestFulBooker rfb = new RestFulBooker();
//        rfb.bookingid;
        Assert.assertTrue(name.contains("Neeru"));
    }
}
