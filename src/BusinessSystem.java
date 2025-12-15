import java.util.ArrayList;
import java.util.Scanner;

public class BusinessSystem {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        employees.add(new Manager(1, "Ahmed", 10000, 3000));
        employees.add(new SalesPerson(2, "Sara", 8000, 2000));
        employees.add(new Intern(3, "Omar"));

        int choice;

        do {
            System.out.println("\n--- Business Employee Management System ---");
            System.out.println("1. View All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. View Total Payroll");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    for (Employee emp : employees) {
                        emp.displayInfo();

                        if (emp instanceof Manager) {
                            System.out.println("Role: Manager");
                        } else if (emp instanceof SalesPerson) {
                            System.out.println("Role: Sales Person");
                        } else if (emp instanceof Intern) {
                            System.out.println("Role: Intern");
                        }

                        System.out.println("Final Salary: " + emp.calculateSalary());
                        System.out.println("-------------------------");
                    }
                    System.out.println("Total Employees: " + Employee.getEmployeeCount());
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Select Role: 1-Manager  2-SalesPerson  3-Intern");
                    int role = scanner.nextInt();

                    if (role == 1) {
                        System.out.print("Enter Base Salary: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter Bonus: ");
                        double bonus = scanner.nextDouble();
                        employees.add(new Manager(id, name, base, bonus));

                    } else if (role == 2) {
                        System.out.print("Enter Base Salary: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter Commission: ");
                        double commission = scanner.nextDouble();
                        employees.add(new SalesPerson(id, name, base, commission));

                    } else if (role == 3) {
                        employees.add(new Intern(id, name));
                    }

                    System.out.println("Employee added successfully!");
                    break;

                case 3:
                    double totalPayroll = 0;
                    for (Employee emp : employees) {
                        totalPayroll += emp.calculateSalary();
                    }
                    System.out.println("Total Payroll: " + totalPayroll);
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}
