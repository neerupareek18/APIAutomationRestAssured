package SelfPacedPractice_17092024;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeaderDemo {
    @Test
    public void getAllHeaders(){
        RequestSpecification rs = given().relaxedHTTPSValidation();
        Response r = rs.when().get("https://www.google.com/");

        Headers h = r.getHeaders();

        for(Header h1: h){
            System.out.println(h1.getName()+" = "+h1.getValue());
        }

    }

    @Test
    public void verifyHeaderValue(){
        given().relaxedHTTPSValidation()
                .when().get("https://www.google.com/")
                .then().header("Cache-Control","private, max-age=0")
                .and()
                .header("Content-Type","text/html; charset=ISO-8859-1");
    }
}
