package Ex15092024_CRUD.Patterns;

public class NoDesginPattern {
    public void stept1(){
        System.out.println("Step 1");
    }

    public static void main(String[] args) {
        NoDesginPattern nd = new NoDesginPattern();
        nd.stept1();
        //Same reference call all the methods from the class
    }
}
