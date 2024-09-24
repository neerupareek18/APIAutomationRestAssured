package Ex22092024.Assignment.Assignment01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingId {

    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;


    public String createBooking(){
        CreateBookingRequest cbr = new CreateBookingRequest();
        String payload = cbr.bookingRequest();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType("application/json");
        rs.body(payload);

        r = rs.when().post();
        vr = r.then().statusCode(200);

        String bookingId = r.jsonPath().getString("bookingid");
        System.out.println(bookingId);

        return bookingId;
    }
}
