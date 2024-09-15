package Ex15092024_CRUD.Get;

import io.restassured.RestAssured;

public class BDDStyleGet {

    //https://api.zippopotam.us/IN/560037

    public static void main(String[] args) {

        test1();
        test2();

    }

    public static void test1(){
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/560037").relaxedHTTPSValidation()
                //to ignore SSL Certifcation issue
                .when().get()
                .then().log().all().statusCode(200);
    }

    public static void test2(){
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/-1").relaxedHTTPSValidation()
                //to ignore SSL Certifcation issue
                .when().get()
                .then().log().all().statusCode(201);
    }


}
