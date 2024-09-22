package Ex21092024.TestNGEx;

import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class TestNG008 {
    /*
    Priorities of the methods canbe set in 4 ways:
    priority tag
    Depends upon
    define the methods in sequence in testng file
    provide the names in alphabeticalOrder
     */

    @Owner("Neeru")
    @Test
    public void TC01(){
        System.out.println("1");
    }
}
