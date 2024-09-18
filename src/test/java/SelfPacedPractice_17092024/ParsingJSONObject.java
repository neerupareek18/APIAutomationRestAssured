package SelfPacedPractice_17092024;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ParsingJSONObject {
    String token1;

    @Test(priority = 1)
    public void createToken(){
        HashMap<String, String> hm = new HashMap<>();
        hm.put("username", "admin");
        hm.put("password", "password123");

        JSONObject data1 = new JSONObject();
        data1.put("username", "admin");
        data1.put("password", "password123");

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(payload)
                .when().post("https://restful-booker.herokuapp.com/auth");

        System.out.println(res.asString());

        JSONObject data = new JSONObject(res.asString());

        token1 = (String) data.get("token");
    }

    @Test (priority = 2)
    public void createUser(){
        String req = "{\n" +
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

        given().relaxedHTTPSValidation().header("Authorization", "Bearer "+token1).body(req)
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then().statusCode(200);

    }
}
