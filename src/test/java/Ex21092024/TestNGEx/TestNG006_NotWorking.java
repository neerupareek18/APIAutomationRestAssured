package Ex21092024.TestNGEx;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG006_NotWorking {

    //in rela time, we avoid using priorities

    @Parameters("name")
    @Test ()
    public void startBrowser(String name){

        System.out.println("Browser name is "+name);
    }
}
