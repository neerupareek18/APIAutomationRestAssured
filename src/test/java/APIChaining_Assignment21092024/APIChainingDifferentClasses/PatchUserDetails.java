package APIChaining_Assignment21092024.APIChainingDifferentClasses;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class PatchUserDetails {
    RequestSpecification rs = given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    @Test
    public void patchUserDetails() throws FileNotFoundException {
        GetToken_CreateUser gt = new GetToken_CreateUser();
        String token = gt.getToken();
        String bookingid = gt.createBooking();

        File f = new File(".\\data2.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        //rs.header("Authorization", "Bearer "+token);
        rs.cookie("token", token);
        rs.contentType("application/json");
        rs.body(jo.toString());

        r = rs.when().put();
        vr = r.then().log().all().statusCode(200);

        String firstname = r.jsonPath().getString("booking.firstname");
        //Assert.assertEquals(firstname,"Riya");
        SoftAssert s = new SoftAssert();
        s.assertEquals(firstname,"Tina");
        System.out.println("This line will be printed after soft assert");
    }
}
