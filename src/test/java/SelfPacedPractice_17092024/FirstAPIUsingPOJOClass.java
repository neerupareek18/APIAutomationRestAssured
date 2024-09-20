package SelfPacedPractice_17092024;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstAPIUsingPOJOClass {

    @Test
    public void createUser(){
        POJOClass p = new POJOClass();
        p.setName("Neeru");
        p.setJob("QA");

       given().relaxedHTTPSValidation()
                .contentType("application/json").body(p)
                .when().post("https://reqres.in/api/users");
                //.jsonPath().getInt("id");

        //System.out.println(id);
    }

}
