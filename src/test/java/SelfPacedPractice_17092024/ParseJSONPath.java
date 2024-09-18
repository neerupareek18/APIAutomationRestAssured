package SelfPacedPractice_17092024;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ParseJSONPath {
    @Test(priority = 1)
    public void getAllBookings(){
        Response res = given().relaxedHTTPSValidation()
                .when().get("https://restful-booker.herokuapp.com/booking");

        System.out.println(res.asString());

        JsonPath data = res.jsonPath();
        ArrayList<Integer> l = new ArrayList<>(data.get("bookingid"));

        for(int i : l){
            System.out.println(i);
        }
    }
}
