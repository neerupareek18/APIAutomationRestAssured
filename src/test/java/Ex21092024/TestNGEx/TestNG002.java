package Ex21092024.TestNGEx;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class TestNG002 {
    @BeforeTest
    public void getToken(){
        System.out.println("3");
    }
    @BeforeTest
    public void getBookingId(){
        System.out.println("1");
    }
    @Test
    public void put(){
        System.out.println("2");
    }
}
