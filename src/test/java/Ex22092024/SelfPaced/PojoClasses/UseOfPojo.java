package Ex22092024.SelfPaced.PojoClasses;

import com.google.gson.Gson;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UseOfPojo {

    public static void main(String[] args) {
        POJOClass p = new POJOClass();
        String a1[] = {"Joe", "John", "Dale"};

        p.setA(a1);
        p.setName("Neeru");

        Pojo2Class p2 = new Pojo2Class();
        p2.setJob("QA");
        p2.setQual("Eng");

        p.setProfession(p2);

        System.out.println(Arrays.toString(p.getA()));
        System.out.println(p.getName());
        System.out.println(p.getProfession()); //Did not gave the correct format output
//
        Gson g = new Gson();
        String s = g.toJson(p);
//
        System.out.println(s);

        //DeSerialization:
        //BookingResponse br = g.fromJson(responseString, BookingResponse.class);


    }
}
