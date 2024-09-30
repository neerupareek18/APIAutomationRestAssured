package SelfPacedPractice_28092024;

import java.util.ArrayList;

public class StudentArrayRequestPojo {
    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    private String schoolname;
    private  ArrayList <StudentRequestPojo> students;

    public ArrayList<StudentRequestPojo> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentRequestPojo> students) {
        this.students = students;
    }


}
