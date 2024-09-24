package Ex22092024.Assignment.Assignment0246;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

//Create a Booking, Delete the Booking with Id and Verify using GET request that it should not exist.

public class GetBookingDetailsAfterDelete_02 {

    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    @Test
    public void getBookingDetailsAfterDelete(){

        DeleteBooking_04 db = new DeleteBooking_04();
        String bookingId = db.deleteBooking();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingId);

        r = rs.when().get();
        vr = r.then().statusCode(404);

        String content_type = r.getContentType();

    }
}
