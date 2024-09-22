package APIChaining_Assignment21092024.ReqResAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GetUserDetails {
    RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation();
    Response r ;
    int index;
    String first_name;
    @Test
    public void getUseDetails(ITestContext totalpages, ITestContext perpagerecords){
        //String tp2 = (String) totalpages.getAttribute("tp1");
        //int ppr2 = (int) perpagerecords.getAttribute("ppr1");

        rs.baseUri("https://reqres.in/");

        boolean status = false;

        for(int i =1; i<3;i++){

rs.basePath("api/users?page="+i);
Response r = rs.when().get();

            ArrayList<HashMap> data = new ArrayList<>();
            data = r.jsonPath().get("data");

            for(HashMap hm: data){

                ArrayList <String> al = (ArrayList<String>) hm.keySet();

                for(int i1=0; i1<al.size();i1++){
                    if(al.get(i1).equalsIgnoreCase("id")){
                        index=i1+1;
                    }
                }
                try {
                    String id_value = (String) hm.get(al.get(index-1));
                    if(id_value.equalsIgnoreCase("123")){
                        status=true;
                        first_name = (String) hm.get("firstname");
                        System.out.println(first_name);
                        break;
                    }
                }
                catch(NullPointerException e){
                    System.out.println("Index not found with given key");
                }

            }
        }
   }
}
