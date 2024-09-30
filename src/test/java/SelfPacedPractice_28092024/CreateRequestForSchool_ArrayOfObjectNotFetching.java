package SelfPacedPractice_28092024;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreateRequestForSchool_ArrayOfObjectNotFetching {

    @Test
    public void createRequest() {
        ArrayList al = new ArrayList();
        Gson g = new Gson();
        StudentRequestPojo stReq = new StudentRequestPojo();
        stReq.setId(1);
        stReq.setName("Neeru");
        stReq.setIspaid(true);
        al.add(stReq);

        stReq.setId(2);
        stReq.setName("Riya");
        stReq.setIspaid(false);
        al.add(stReq);

        StudentArrayRequestPojo stArr = new StudentArrayRequestPojo();
        stArr.setStudents(al);

        StudentArrayRequestPojo payloadJson = new StudentArrayRequestPojo();
        payloadJson.setSchoolname("TPS");
        payloadJson.setStudents(al);

        String requestPayload = g.toJson(payloadJson);
        System.out.println(requestPayload);

        StudentArrayRequestPojo responsePayload = g.fromJson(requestPayload, StudentArrayRequestPojo.class);
        String schoolName = responsePayload.getSchoolname();
        StudentRequestPojo[] students = responsePayload.getStudents().toArray(new StudentRequestPojo[0]);

        System.out.println(schoolName);
        System.out.println(students);

    }
}
