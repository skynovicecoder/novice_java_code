package practice.dailypractice.augtentwentyfive;

public class ReturnTest {
    public static int test() {
        try {
            return 1;
        } finally {
            return 5;
        }
    }

    public static void main(String[] args){
        System.out.println(test());
    }
}
