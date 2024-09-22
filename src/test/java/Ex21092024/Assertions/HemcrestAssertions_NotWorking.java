package Ex21092024.Assertions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class HemcrestAssertions_NotWorking {
    RequestSpecification rs = given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;


    public void test_post() {
        String payload = "{\n" +
                "    \"firstname\" : \"Neeru\",\n" +
                "    \"lastname\" : \"Pareek\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType("application/json");
        rs.body(payload);

        r = rs.when().post();
        vr = r.then().log().all();
        vr.statusCode(200);
        vr.statusLine("200 OK");

        //No need to add the Hamcrest dependency now, just the library is present, import the package

        String firstname = r.jsonPath().getString("booking.firstname");
        //vr = (ValidatableResponse) r.body(firstname, Matchers.equalTo("Neeru"));
        Assert.assertEquals(firstname, "Neeru");
    }
}