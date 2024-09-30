package APIChaining_Assignment21092024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestFulBooker {
    RequestSpecification rs = given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;
    String token;
    public String bookingid;

@Test
    public void getToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payload);


        r = rs.when().post();
        //vr = r.then().statusLine("OK");
        vr = r.then().statusCode(200);
        vr = r.then().log().all();

        token = r.jsonPath().getString("token");
        System.out.println(token);

        JsonPath jp = r.jsonPath();
        token = jp.getString("token");
        System.out.println(token);

    }

@Test
    public void createBooking(){

    String payload = "{\n" +
            "    \"firstname\" : \"Neeru\",\n" +
            "    \"lastname\" : \"Pareek\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType("application/json");
        rs.body(payload);

        r = rs.when().post();
        r.then().log().all();
        bookingid = r.jsonPath().getString("bookingid");
        System.out.println(bookingid);

        String firstname = r.jsonPath().getString("booking.firstname");
        Assert.assertEquals(firstname,"Neeru");
    }

    @Test(dependsOnMethods = {"createBooking"})
public void getBookingDetails(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
   r= rs.when().get();
            //.then().log().all().statusCode(200);

        String firstname = r.then().extract().path("firstname");
        System.out.println(firstname);

        HashMap hm = r.then().extract().path("bookingdates");
        ArrayList<String> al = (ArrayList<String>) hm.keySet();

        for(String s:al){
            System.out.println(s+"="+hm.get(s));
        }

String an = r.then().extract().path("addtionalneeds");
        System.out.println(an);


    }

    @Test(dependsOnMethods = {"createBooking","getToken"})
    public void updateBooking() throws FileNotFoundException {

    File f = new File(".\\data2.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        //rs.header("Authorization", "Bearer "+token);
        rs.cookie("token", token);
        rs.contentType("application/json");
        rs.body(jo.toString());

        r = rs.when().put();
        vr = r.then().log().all().statusCode(200);

String firstname = r.jsonPath().getString("booking.firstname");
        //Assert.assertEquals(firstname,"Riya");
        SoftAssert s = new SoftAssert();
        s.assertEquals(firstname,"Tina");
        System.out.println("This line will be printed after soft assert");
    }
    @Test(priority = 4)
    public void deleteBooking(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.cookie("token", token);

        r =rs.when().delete();
        vr = r.then().statusCode(201);

    }

    @Test(dependsOnMethods = {"deleteBooking"})
    public void getBookingDetails_AfterDelete(){
        given().relaxedHTTPSValidation()
                .when().get("https://restful-booker.herokuapp.com/booking/"+bookingid)
                .then().log().all().statusCode(404);
    }
}
