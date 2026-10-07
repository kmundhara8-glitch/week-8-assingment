import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {

        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {

        return Math.max(hours * 50, 100);
    }
}

public class ParkingCharge {

    static Vehicle createVehicle(
            String type,
            int hours) {

        switch (type) {

            case "BIKE":
                return new Bike(hours);

            case "CAR":
                return new Car(hours);

            case "TRUCK":
                return new Truck(hours);

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
            int hours = sc.nextInt();

            Vehicle vehicle =
                    createVehicle(type, hours);

            double charge =
                    vehicle.calculateCharge();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    charge
            );

            total += charge;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}