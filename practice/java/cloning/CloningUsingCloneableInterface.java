package practice.java.cloning;

class CmpEmployees implements Cloneable {
    int id;
    String name;

    public CmpEmployees() {
    }

    public CmpEmployees(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CmpEmployees clone() {
        try {
            CmpEmployees copyObj = (CmpEmployees) super.clone();
            return copyObj;
        } catch (CloneNotSupportedException exp) {
            System.out.println("Exception: " + exp.getMessage());
            return new CmpEmployees();
        }
    }

}

public class CloningUsingCloneableInterface {
    public static void main(String[] args) {
        CmpEmployees obj = new CmpEmployees("Gokhu", 1);
        CmpEmployees copyObj = obj.clone();
        copyObj.setId(8);

        System.out.println("ID: " + obj.getId() + " : Name: " + obj.getName());
        System.out.println("ID: " + copyObj.getId() + " : Name: " + copyObj.getName());
    }
}
