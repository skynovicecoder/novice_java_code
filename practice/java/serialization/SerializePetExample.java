package practice.java.serialization;

import java.io.*;

class Collar {
    private String color;
    private int numberPlate;

    public Collar(String color, int numberPlate) {
        this.color = color;
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Number Plate:" + this.numberPlate + " with color: " + this.color;
    }

}

class Pet implements Serializable {
    private String name;
    private transient Collar collar;

    public Pet(String name, Collar collar) {
        this.name = name;
        this.collar = collar;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", collar=" + collar +
                '}';
    }

}

public class SerializePetExample {
    public static void main(String[] args) throws IOException {
        Pet pet = new Pet("Tommy", new Collar("Red", 123));

        //Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pet.ser"))) {
            oos.writeObject(pet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pet deserializedPet;
        //Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pet.ser"))) {
            deserializedPet = (Pet) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Before Serialization: " + pet);
        System.out.println("After Deserialization: " + deserializedPet);
    }
}
