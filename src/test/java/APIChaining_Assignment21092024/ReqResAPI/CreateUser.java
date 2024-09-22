package APIChaining_Assignment21092024.ReqResAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test
    public void getAllUsers(ITestContext totalpages, ITestContext perpagerecords){
       Response res = given().relaxedHTTPSValidation()
                .when().get("https://reqres.in/api/users?page=1");

        int tp = res.jsonPath().getInt("total_pages");
        int ppr = res.jsonPath().getInt("per_page");

        totalpages.setAttribute("tp1", tp);
        perpagerecords.setAttribute("ppr1",ppr);

        System.out.println(tp);
        System.out.println(ppr);

        ArrayList<HashMap> data = new ArrayList<>();
        data = res.jsonPath().get("data");
        System.out.println(data.size());
        System.out.println(data.get(0));
        System.out.println(data.get(0).keySet());

        for(HashMap hm: data){
            System.out.println(hm.toString());
            ArrayList <String> al = new ArrayList(hm.keySet());
            for(int i=0;i<al.size();i++){
                String key = al.get(i);
                System.out.println(hm.get(key));
            }
        }



    }

    @Test
    public void createUser(ITestContext id){
     Response r = given().relaxedHTTPSValidation().contentType(ContentType.JSON)
              .body("{\n" +
                      "    \"name\": \"morpheus\",\n" +
                      "    \"job\": \"leader\"\n" +
                      "}")
                .when().post("https://reqres.in/api/users");
                //.then().body("id",327);

        String id2 = r.jsonPath().getString("id");
        id.setAttribute("user_id",id2);
    }


}

