package practice.java.ErrorTesting;

public class StackOverFlowError {
    public static void recurse(){
        recurse();
    }
    public static void main(String[] args){
        try{
            recurse();
        }catch (StackOverflowError err){
            System.out.println("Stack Overflow error : "+err.getMessage());
        }
    }
}
