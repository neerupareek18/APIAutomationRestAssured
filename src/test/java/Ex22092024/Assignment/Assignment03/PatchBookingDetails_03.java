package Ex22092024.Assignment.Assignment03;

import Ex22092024.Assignment.Assignment01.GetToken;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

//Get an Existing Booking from Get All Bookings Ids , Update a Booking and Verify using GET by id. 

public class PatchBookingDetails_03 {
    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r;
    ValidatableResponse vr;
    boolean status;
    String bookingId;

    @Test
    public void getAllBookings(){
        GetBookingId gbi = new GetBookingId();
        bookingId = gbi.createBooking();

        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");

        r = rs.when().get();
        vr = r.then().statusCode(200);

        String content_type = r.getContentType();
        System.out.println(content_type);
        Headers h = r.getHeaders();

        String contentTypeHeader = r.header("content-type");
        System.out.println(contentTypeHeader);

        ArrayList<Integer> Ids = new ArrayList<>();
        Ids = r.jsonPath().get("bookingid");

        int bookingId_int = Integer.parseInt(bookingId);
        for(Integer i: Ids){
            //System.out.println(i);
            if(i==bookingId_int){
                status = true;
                break;
            }
        }
    }

    @Test(dependsOnMethods = "getAllBookings")
    public void patchBooking() throws FileNotFoundException {

        GetToken gt = new GetToken();
        String token = gt.getToken();

        File f = new File(".\\patchRequest.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject payload = new JSONObject(jt);
        System.out.println(payload.toString());


        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingId);
        rs.cookie("token", token);
        rs.body(payload);

        r = rs.when().patch();

        if (status == true) {
            vr = r.then().statusCode(200);
        } else {
            vr = r.then().statusCode(404);
        }
    }

    @Test(dependsOnMethods = "patchBooking")
        public void getBookingDetailsAfterPatch(){
            rs.baseUri("https://restful-booker.herokuapp.com");
            rs.basePath("/booking/" + bookingId);
            r = rs.when().get();

            String first_name = r.jsonPath().getString("firstname");
            Assert.assertTrue(first_name.equalsIgnoreCase("Neeru"));
        }


    }
