public class SalesPerson extends Employee {

    private double commission;

    public SalesPerson(int id, String name, double baseSalary, double commission) {
        super(id, name, baseSalary);
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + commission;
    }
}
