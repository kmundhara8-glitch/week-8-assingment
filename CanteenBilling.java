import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {

    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {

    static Customer createCustomer(String type, double amount) {

        switch (type) {
            case "STUDENT":
                return new Student(amount);

            case "STAFF":
                return new Staff(amount);

            case "GUEST":
                return new Guest(amount);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer =
                    createCustomer(type, amount);

            double finalAmount =
                    customer.calculateFinalAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    finalAmount
            );

            total += finalAmount;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}