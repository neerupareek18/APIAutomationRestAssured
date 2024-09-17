package SelfPacedPractice_17092024;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

@Test (priority = 1)
public class CookiesDemo {
    public void verifyCookieExistence(){
        given().relaxedHTTPSValidation()
                .when().get("https://www.google.com/")
                .then().cookie("AEC","abcd").log().all();
    }

    @Test (priority = 2)
    public void getSingleCookieValue(){
        String Cookie = given().relaxedHTTPSValidation()
                .when().get("https://www.google.com/")
                .getCookie("AEC");
        System.out.println(Cookie);

        //OR

        Response res = given().relaxedHTTPSValidation()
                .when().get("https://www.google.com/");

        String Cookie1 = res.getCookie("AEC");
        System.out.println(Cookie1);
    }

    @Test (priority = 3)
    public void getAllCokkies(){
Response res = given().relaxedHTTPSValidation()
        .when().get("https://www.google.com/");

Map<String, String> cookies = res.getCookies();

for(String key : cookies.keySet()){
    System.out.println(key + " = "+res.getCookie(key));
}


    }
}
