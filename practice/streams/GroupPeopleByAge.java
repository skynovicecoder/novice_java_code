package practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class People{
    String name;
    int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class GroupPeopleByAge {
    public static void main(String[] args){
        List<People> pepleList = new ArrayList(Arrays.asList(
                new People("Sonil", 36),
                new People("Sky", 35),
                new People("Rocky", 36),
                new People("Don", 33),
                new People("Boss", 35))
        );

        Map<Integer, List<People>> result= pepleList.stream()
                .collect(Collectors.groupingBy(People::getAge));
        System.out.println(result);
    }
}
