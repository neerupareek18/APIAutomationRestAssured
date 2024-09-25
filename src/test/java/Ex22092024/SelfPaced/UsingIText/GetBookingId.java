package Ex22092024.SelfPaced.UsingIText;

import Ex22092024.Assignment.Assignment01.BookingDatesPojo;
import Ex22092024.Assignment.Assignment01.BookingPojo;
import Ex22092024.Assignment.Assignment01.CreateBookingRequest;
import Ex22092024.Assignment.Assignment01.ResponsePojo;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
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

@Test
    public void createBooking(ITestContext context){
//        CreateBookingRequest cbr = new CreateBookingRequest();
//        String payload = cbr.bookingRequest();

    BookingPojo bp = new BookingPojo();
    BookingDatesPojo bdp = new BookingDatesPojo();

    Faker f = new Faker();
    bp.setFirstname(f.name().firstName());
    bp.setLastname(f.name().lastName());
    bp.setTotalprice(Integer.valueOf(f.number().digits(3)));
    bp.setDepositpaid(true);
    bp.setAdditionalneeds(f.food().ingredient());


    bdp.setCheckout("2024-10-01");
    bdp.setCheckin("2024-09-28");

    bp.setBookingdates(bdp);

    Gson g = new Gson();
    String payload = g.toJson(bp);
    System.out.println(payload);

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType("application/json");
        rs.body(payload);

        r = rs.when().post();
        String string_response = r.asString();
        //vr = r.then().statusCode(200);

        String bookingId = r.jsonPath().getString("bookingid");
        System.out.println(bookingId);


    ResponsePojo rp = g.fromJson(string_response,ResponsePojo.class);

    String resId = rp.getBookingid();
    System.out.println(resId);

    context.setAttribute("id",bookingId);

    }
}
