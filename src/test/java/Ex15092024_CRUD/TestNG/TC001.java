package Ex15092024_CRUD.TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TC001 {
    @Test //Using TestNG annotation -- we can run the test cases without main method
    public void test_Get(){
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/302002").relaxedHTTPSValidation()
                //to ignore SSL Certifcation issue
                .when().get()
                .then().log().all().statusCode(200);
    }
}
