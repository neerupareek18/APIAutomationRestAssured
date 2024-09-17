package SelfPacedPractice_17092024;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestWithToken {
    @Test
    public void createUser() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Neeru");
        hm.put("gender", "Female");
        hm.put("email", "neeruqa@yopmail.com");
        hm.put("status", "active");

        String token = "455635bd00a783d2b3e9d82e7a7cf0a869a65d7e6e5d61c7494175ff9b2bb130";
        given().relaxedHTTPSValidation()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON).body(hm)

                .when().post("https://gorest.co.in/public/v2/users")
                .then().statusCode(201);

    }
}