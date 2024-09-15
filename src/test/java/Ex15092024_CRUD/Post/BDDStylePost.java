package Ex15092024_CRUD.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePost {
    //Post Request, url, body, headers
    /*
    https://restful-booker.herokuapp.com
    {
    "username" : "admin",
    "password" : "password123"
}
Header -- Content Type
     */
    public static void main(String[] args) {
        //Payload can be given in String, Payloads, Classes.....Classes are used 90%

        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
                .contentType(ContentType.JSON).log().all().body(payload).relaxedHTTPSValidation().log().all()
                .when().log().all()
                .post()
                .then().statusCode(200).log().all();
    }
}
