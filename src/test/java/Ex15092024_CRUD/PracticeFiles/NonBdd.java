package Ex15092024_CRUD.PracticeFiles;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBdd {

    static RequestSpecification r = RestAssured.given().relaxedHTTPSValidation();

    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");
        test1();
        test2();
    }

    public static void test1(){
        r.basePath("/IN/500034");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }


    public static void test2(){
        r.basePath("/IN/500034");
        r.when().log().all().get();
        r.then().log().all().statusCode(201);
    }
}