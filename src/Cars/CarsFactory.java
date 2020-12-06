package Cars;

import java.util.Random;
import java.util.UUID;

public class CarsFactory {
    private static final int MILEAGE_RANGE = 60_000;
    private static final int BASE_YEAR = 2011;
    private static final int RANGE_YEAR = 10;
    private static final int BASE_PRICE = 30_000;
    private static final int RANGE_PRICE = 15_000;

    public static Car getCar() {
        Random random = new Random();

        return new Car(
                UUID.randomUUID(),
                AutoBrand.getRandom(),
                random.nextInt(RANGE_YEAR) + BASE_YEAR,
                random.nextInt(MILEAGE_RANGE),
                random.nextInt(RANGE_PRICE) + BASE_PRICE
        );
    }
}

