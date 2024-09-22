package Ex21092024.TestNGEx;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG01
    /*
    IntelliJ will create TestNG temp file, two functions (with @Test annotation) will be copied in the java main method and IntelliJ will run the code
     */

{
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify true==true")
    @Test
    public void TC01(){
Assert.assertEquals(true, true);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Verify true!=false")
    @Test
    public void TC02(){
        Assert.assertEquals(false, true);
    }
}
