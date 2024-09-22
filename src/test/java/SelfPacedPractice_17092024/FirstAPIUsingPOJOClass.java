package SelfPacedPractice_17092024;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class FirstAPIUsingPOJOClass {

    @Test
    public void createUser(){
        POJOClass p = new POJOClass();
        p.setName("Neeru");
        p.setJob("QA");

        HashMap <String, String> hm = new HashMap<>();
        hm.put("name", "Neeru123");
        hm.put("job", "SQA");

        given().relaxedHTTPSValidation()
                .contentType("application/json").body(p)
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201);

       given().relaxedHTTPSValidation()
                .contentType("application/json").body(hm)
                .when().post("https://reqres.in/api/users")
               .then().statusCode(201);
                //.jsonPath().getInt("id");

        //System.out.println(id);
    }

}
