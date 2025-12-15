public class Intern extends Employee {

    public Intern(int id, String name) {
        super(id, name, 0);
    }

    @Override
    public double calculateSalary() {
        return 5000;
    }
}
