import java.time.LocalDate;
import java.util.Scanner;

abstract class StreamingPlan {

    protected LocalDate startDate;

    StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {

    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {

    static StreamingPlan createPlan(
            String type,
            LocalDate startDate) {

        switch (type) {

            case "BASIC":
                return new BasicPlan(startDate);

            case "STANDARD":
                return new StandardPlan(startDate);

            case "PREMIUM":
                return new PremiumPlan(startDate);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            StreamingPlan plan =
                    createPlan(
                            type,
                            startDate
                    );

            System.out.println(
                    name + ": "
                    + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}