package SelfPacedPractice_17092024;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DifferentTypeLogs {
    @Test
    public void verifyOnlyHeaders(){
        given().relaxedHTTPSValidation()
                .when().get("https://www.google.com")
                .then().log().headers();
    }

    @Test
    public void verifyOnlyCookies(){
        given().relaxedHTTPSValidation()
                .when().get("https://www.google.com")
                .then().log().cookies();
    }

    @Test
    public void verifyOnlyBody(){
        given().relaxedHTTPSValidation()
                .when().get("https://www.google.com")
                .then().log().body();
    }


}
