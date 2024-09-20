package SelfPacedPractice_17092024;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class ExJSONObject {
    String token1;

    @Test(priority = 1)
    public void createToken(ITestContext token123) throws FileNotFoundException {
//        HashMap<String, String> hm = new HashMap<>();
//        hm.put("username", "admin");
//        hm.put("password", "password123");
//
//        JSONObject data1 = new JSONObject();
//        data1.put("username", "admin");
//        data1.put("password", "password123");
//
//        String payload = "{\n" +
//                "    \"username\" : \"admin\",\n" +
//                "    \"password\" : \"password123\"\n" +
//                "}";

File f = new File(".\\data1.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data1 = new JSONObject(jt);

        Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(data1.toString())
                .when().post("https://restful-booker.herokuapp.com/auth");

        System.out.println(res.asString());

        JSONObject data = new JSONObject(res.asString());

        token1 = (String) data.get("token");
        token123.setAttribute("token_method",token1);
    }

    @Test (priority = 2)
    public void createUser(ITestContext token123){
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

        String token2 = (String) token123.getAttribute("token_method");
        given().relaxedHTTPSValidation().header("Authorization", "Bearer "+token2).body(req)
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then().statusCode(200);

    }
}
