package Ex15092024_CRUD.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.post;

public class NonBDD {
    public static void main(String[] args) {
        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all().body(payload);
                r.relaxedHTTPSValidation().log().all();

//Making of Request
                Response re = r.when().log().all().post();

                //Validation of response

      //ResponseSpecification rs = r.then(); -----This can also be used
        ValidatableResponse rs = re.then();
        rs.statusCode(200).log().all();
    }
}
