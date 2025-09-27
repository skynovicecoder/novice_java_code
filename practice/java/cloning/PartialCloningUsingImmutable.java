package practice.java.cloning;

final class CompanyEmployees {
    private final int id;
    private final String name;

    public CompanyEmployees(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //2.Immutable CompanyEmployees
    public CompanyEmployees withDiffID(int id) {
        return new CompanyEmployees(this.getName(), id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

public class PartialCloningUsingImmutable {
    public static void main(String[] args) {
        CompanyEmployees obj = new CompanyEmployees("Vegita", 2);
        CompanyEmployees copyObj = obj.withDiffID(5);

        System.out.println("ID: " + obj.getId() + " : Name: " + obj.getName());
        System.out.println("ID: " + copyObj.getId() + " : Name: " + copyObj.getName());
    }
}
