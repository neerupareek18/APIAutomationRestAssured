package Ex15092024_CRUD.Get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    static RequestSpecification rs = RestAssured.given();


    public static void main(String[] args) {
        //RestAssured provides lot of classes
        //Classes -- given() RequestSpecification interface, ResponseSpecification (then()), Response
        rs.baseUri("https://api.zippopotam.us");

        test1();
        test2();
    }

    private static void test1(){
        rs.basePath("/IN/560037");
        rs.relaxedHTTPSValidation();
        rs.when().get();
        rs.then().statusCode(200);
    }

    private static void test2(){
        rs.basePath("/IN/-1");
        rs.relaxedHTTPSValidation(); //to ignore SSL Certifcation issue
        rs.when().get();
        rs.then().statusCode(200);
    }
}
