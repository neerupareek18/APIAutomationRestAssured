package APIChaining_Assignment21092024.APIChainingDifferentClasses;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class GetToken_CreateUser {
    RequestSpecification rs = given().relaxedHTTPSValidation();
    Response r;
    String token;
    String bookingid;

    @Test
    public String getToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);


        r = rs.when().post();

        token = r.jsonPath().getString("token");
        System.out.println(token);

        return token;
    }

    @Test
    public String createBooking() {

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
        r.then().log().all();
        bookingid = r.jsonPath().getString("bookingid");
        System.out.println(bookingid);

        return bookingid;
    }
}
