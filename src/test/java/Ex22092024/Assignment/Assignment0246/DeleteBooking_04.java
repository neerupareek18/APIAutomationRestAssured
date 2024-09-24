package Ex22092024.Assignment.Assignment0246;

import Ex22092024.Assignment.Assignment01.GetToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//Create a BOOKING, Delete It
public class DeleteBooking_04 {
    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    public String deleteBooking(){
        GetToken gt = new GetToken();
        String token = gt.getToken();

        GetBookingId gbi = new GetBookingId();
        String bookingId = gbi.createBooking();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingId);
        rs.cookie("token", token);

        r = rs.when().delete();
        vr = r.then().statusCode(201);

        return bookingId;
    }
}
