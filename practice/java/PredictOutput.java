package practice.java;

//abstract class RandomClass {
class RandomClass {
    int x = 10;

    RandomClass() {
        System.out.println("A constructor: x= " + x); //1 //x=10
        show();
    }

    //abstract void show();
    void show() {
        System.out.println("A show : " + x);
    }
}

public class PredictOutput extends RandomClass {
    int x = 20;

    PredictOutput() {
        System.out.println("B constructor: x = " + x); //2 //x=0 //3 //20
        show();
    }

    void show() {
        System.out.println("B show : " + x); //4 //20
    }

    public static void main(String[] args) {
        RandomClass object = new PredictOutput();
    }
}
