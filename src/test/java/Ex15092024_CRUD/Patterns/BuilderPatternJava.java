package Ex15092024_CRUD.Patterns;

import org.testng.annotations.Test;

public class BuilderPatternJava {
    @Test
    public BuilderPatternJava Stage1(){
        System.out.println("Stage 1");
        return this;
    }
@Test
    public BuilderPatternJava Stage2(String name){
        System.out.println("Satge 2");
        return this;
    }

//    public static void main(String[] args) {
//        BuilderPatternJava bp = new BuilderPatternJava();
//        bp.Stage1().Stage2("Name");
//
//        //Same reference one by one calls all the methods in single statement
//    }
}
