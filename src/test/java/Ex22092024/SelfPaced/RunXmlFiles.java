package Ex22092024.SelfPaced;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class RunXmlFiles {
    public static void main(String[] args) {
        List<String> xmlList = new ArrayList<>();
        xmlList.add("testng01.xml");
        xmlList.add("testng04.xml");

        TestNG test = new TestNG();
        test.setTestSuites(xmlList);
        test.run();
    }
}
