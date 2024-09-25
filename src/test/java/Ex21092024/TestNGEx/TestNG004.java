package Ex21092024.TestNGEx;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG004 {

    @Parameters ("name")
    @Test(groups = {"dev"}, priority = 0)
    public void smokeTest(String name){
        System.out.println("Smoke");
        System.out.println(name);
    }
    @Test(groups = {"sanity", "qa", "e2e"}, priority = 1)
    public void sanityTest(){
        System.out.println("Sanity");
    }
    @Test(groups = {"qa", "reg"}, priority = 2)
    public void RegTest(){
        System.out.println("Regression");
    }
}
