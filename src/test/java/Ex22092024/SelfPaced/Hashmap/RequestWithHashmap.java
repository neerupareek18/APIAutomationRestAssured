package Ex22092024.SelfPaced.Hashmap;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestWithHashmap {
    public static void main(String[] args) {
        Map <String, Object>hm = new HashMap();
        String[] a = {"1","2","3"};
        String name = "Neeru";

        Map <String, String> hm1 = new HashMap<>();
hm1.put("job","QA");
hm1.put("Qual","Eng");

hm.put("age",a);
hm.put("name",name);
hm.put("prof",hm1);

        ArrayList al = new ArrayList();
        al.add(hm1);
        al.add(hm);

        Gson g1 = new Gson();
        String payload1 = g1.toJson(al);
        System.out.println(payload1);

        Gson g = new Gson();
        String payload = g.toJson(hm);

        System.out.println(payload);
    }

}
