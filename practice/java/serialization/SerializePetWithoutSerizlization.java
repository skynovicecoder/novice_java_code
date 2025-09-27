package practice.java.serialization;

import java.io.*;

class Collars {
    private String color;
    private int numberPlate;

    public Collars(String color, int numberPlate) {
        this.color = color;
        this.numberPlate = numberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Number Plate:" + this.numberPlate + " with color: " + this.color;
    }

}

class Pets implements Serializable {
    private String name;
    private transient Collars collar;

    public Pets(String name, Collars collar) {
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

    private void writeObject(ObjectOutputStream oos) throws IOException {
        System.out.println("\nMethod signatures must be exact, You never call them manually.\nThey’re like serializationhooks. \n You usually call defaultWriteObject() / defaultReadObject() inside them\n" +
                "to let Java handle normal fields, while you handle special cases (like our Collar)");
        oos.defaultWriteObject(); // write 'name'
        // write Collar manually
        oos.writeUTF(collar.getColor());
        oos.writeInt(collar.getNumberPlate());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("\nMethod signatures must be exact, You never call them manually.\nThey’re like serializationhooks. \n You usually call defaultWriteObject() / defaultReadObject() inside them\n" +
                "to let Java handle normal fields, while you handle special cases (like our Collar)");
        ois.defaultReadObject(); // read 'name'

        // restore Collar manually
        String color = ois.readUTF();
        int numberPlate = ois.readInt();
        this.collar = new Collars(color, numberPlate);
    }
}

public class SerializePetWithoutSerizlization {
    public static void main(String[] args) throws IOException {
        Pets pets = new Pets("Tommy", new Collars("Red", 123));

        //Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pets.ser"))) {
            oos.writeObject(pets);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pets deserializedPets;
        //Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pets.ser"))) {
            deserializedPets = (Pets) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Before Serialization: " + pets);
        System.out.println("After Deserialization: " + deserializedPets);
    }
}
