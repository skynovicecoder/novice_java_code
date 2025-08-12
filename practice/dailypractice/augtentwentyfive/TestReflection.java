package practice.dailypractice.augtentwentyfive;

import java.lang.reflect.Field;
import java.util.Date;

record EmployeeRef(String name, int age, Date dob) {
}

public class TestReflection {

    public static Object myFunc(EmployeeRef obj, String attribute) {
        try {
            Field field = obj.getClass().getDeclaredField(attribute);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EmployeeRef obj = new EmployeeRef("Sonil", 30, new Date());
        System.out.println(myFunc(obj, "name"));
        System.out.println(myFunc(obj, "age"));
        System.out.println(myFunc(obj, "dob"));
    }
}