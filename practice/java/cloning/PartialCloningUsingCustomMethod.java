package practice.java.cloning;

class CompanyEmployee {
    int id;
    String name;

    public CompanyEmployee(String name, int id) {
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

    //1. Way use custom method
    public CompanyEmployee copyBySameNameDiffID(CompanyEmployee empObj, int id) {
        return new CompanyEmployee(empObj.getName(), id);
    }
}

public class PartialCloningUsingCustomMethod {
    public static void main(String[] args) {
        CompanyEmployee obj = new CompanyEmployee("Gokhu", 1);
        CompanyEmployee copyObj = obj.copyBySameNameDiffID(obj, 3);

        System.out.println("ID: " + obj.getId() + " : Name: " + obj.getName());
        System.out.println("ID: " + copyObj.getId() + " : Name: " + copyObj.getName());
    }
}
