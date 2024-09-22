package Ex21092024.TestNGEx;

import org.testng.annotations.Test;

public class TestNG004 {

    @Test(groups = {"dev"}, priority = 0)
    public void smokeTest(){
        System.out.println("Smoke");
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
