package Ex21092024.Assertions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import static io.restassured.RestAssured.given;

public class AssertJ_FluentAssertion {

    RequestSpecification rs = given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

@Test
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
        vr.statusLine("HTTP/1.1 200 OK");

        String code = r.statusLine();
    System.out.println(code);

    assertThat(code).contains("200 OK");

    String s =""; //Empty
    String s1 = " "; //Blank

    assertThat(s).isEmpty();
    assertThat(s1).isNotEmpty().asString();

        //No need to add the Hamcrest dependency now, just the library is present, import the package

        String firstname = r.jsonPath().getString("booking.firstname");
assertThat(firstname).isNotNull();

int age = -1;
assertThat(age).isPositive().isNotNull();

    }
}
