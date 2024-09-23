package Ex22092024.Assignment.Assignment01;

import java.util.HashMap;

public class TokenRequest {

    public HashMap <String, String> tokenPayload(){
        HashMap <String, String> hm = new HashMap<>();
        hm.put("username" , "admin");
        hm.put("password" , "password123");

        return hm;
    }
}
