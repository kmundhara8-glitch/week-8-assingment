import java.util.Scanner;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {

    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {

    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {

    ACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricity {

    static Room createRoom(
            String type,
            int units,
            int occupants) {

        switch (type) {

            case "SINGLE":
                return new SingleRoom(units);

            case "SHARED":
                return new SharedRoom(
                        units,
                        occupants
                );

            case "AC":
                return new ACRoom(units);

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
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room =
                    createRoom(
                            type,
                            units,
                            occupants
                    );

            double bill =
                    room.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    bill
            );

            total += bill;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}