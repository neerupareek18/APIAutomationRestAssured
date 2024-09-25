package Ex22092024.Assignment.Assignment01;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

public class GetToken {

    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;

    public String getToken(){
        System.out.println("Token Fetching");
        TokenRequest tr = new TokenRequest();
        HashMap hm = tr.tokenPayload();

        Gson g = new Gson();
        String payload = g.toJson(hm);

        System.out.println(payload);

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);


        r = rs.when().post();
        vr = r.then().statusCode(200);

        String statusLine = r.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("OK"));

        String token = r.body().jsonPath().getString("token");
        System.out.println(token);


        return token;

    }
}
