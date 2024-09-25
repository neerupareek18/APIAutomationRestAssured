package Ex22092024.Assignment.Assignment0246;

import Ex22092024.Assignment.Assignment01.GetToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Trying to Update on a Delete Id -> 404

public class UpdateBookingAfterDelete_06 {
    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    @Test
    public void updateBookingAfterDelete() throws FileNotFoundException {
        GetToken gt = new GetToken();
        String token = gt.getToken();

        DeleteBooking_04 db = new DeleteBooking_04();
        String bookingId = db.deleteBooking();

        File f = new File(".\\putRequest.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject payload = new JSONObject(jt);
        System.out.println(payload.toString());


        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingId);
        rs.cookie("token", token);
        rs.body(payload);

        r = rs.when().put();
        vr = r.then().statusCode(400);
    }
}
