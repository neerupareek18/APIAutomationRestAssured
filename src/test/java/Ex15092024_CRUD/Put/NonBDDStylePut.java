package Ex15092024_CRUD.Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePut {
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;


    @Test
    public void put(){
        String token1 = "4e41f7a7dd706e5";
        String bookingid = "532";
        String payload = "{\n" +
                "    \"firstname\" : \"Neeru\",\n" +
                "    \"lastname\" : \"Pareek\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Dinner\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("booking"+bookingid);
        rs.relaxedHTTPSValidation();
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token1);
        rs.body(payload);

        r = rs.when().put();

        vr = r.then();
        vr.statusCode(404);

    }


}
