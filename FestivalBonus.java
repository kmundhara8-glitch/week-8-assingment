import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {

    static Employee createEmployee(
            String type,
            String name,
            double salary) {

        switch (type) {

            case "FULLTIME":
                return new FullTimeEmployee(
                        name,
                        salary
                );

            case "PARTTIME":
                return new PartTimeEmployee(
                        name,
                        salary
                );

            case "INTERN":
                return new InternEmployee(
                        name,
                        salary
                );

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee =
                    createEmployee(
                            type,
                            name,
                            salary
                    );

            double bonus =
                    employee.calculateBonus();

            System.out.printf(
                    "%s: %.2f%n",
                    name,
                    bonus
            );

            totalBonus += bonus;
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus
        );

        sc.close();
    }
}