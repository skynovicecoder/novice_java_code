package practice.java;

class Box{
    int value;
}
public class CallByValueOrCallByReference {
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4};
        var box = new Box();
        box.value = 20;
        var str = "SBER";
        //var str = new StringBuilder("SBER");
        modify(arr, box, str);
        System.out.println(arr[0] + " " + box.value + " " + str);
        // 100, 20, SBER
    }

    static void modify(int[] arr, Box box, String str) {
        arr[0] = 100;
        box = new Box();
        box.value = 50;
        str += "BANK";
        //str.append("BANK");  // mutates same object
    }
}
