package Ex22092024.Assignment.Assignment03;

import Ex22092024.Assignment.Assignment01.CreateBookingRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
