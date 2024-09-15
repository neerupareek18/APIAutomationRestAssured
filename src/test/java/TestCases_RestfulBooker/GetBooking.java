package TestCases_RestfulBooker;

import io.restassured.RestAssured;

public class GetBooking {
    public static void main(String[] args) {
        System.out.println("Rest Assured TC");
        System.out.println("GET Request");

        /*
        Gherkin Syntax
        given() -- url, headers, body, payload
        when() -- http methods
        then() -- verify the response
         */

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("booking/1").log().all()
                .when().get()
                .then().statusCode(200).log().all();

        //given, when, then are static methods as they are called directly by the class name RestAssured
    }
}
