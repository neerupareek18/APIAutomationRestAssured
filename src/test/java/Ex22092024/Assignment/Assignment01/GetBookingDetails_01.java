package Ex22092024.Assignment.Assignment01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

//Create a Booking, Update the Booking Name, Get the Booking by Id and verify.

public class GetBookingDetails_01 {
    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    @Test
    public void getBookingDetails(){

        GetBookingId gbi = new GetBookingId();
        String bookingId = gbi.createBooking();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingId);

        r = rs.when().get();
        String string_response = r.asString();
        vr = r.then().statusCode(200);

        String content_type = r.getContentType();
        assertThat(content_type.contains("application-json"));

        System.out.println(r.getTimeIn(TimeUnit.SECONDS));
            }
}
