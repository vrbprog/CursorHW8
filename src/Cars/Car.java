package Cars;

import java.util.Objects;
import java.util.UUID;

public class Car implements Comparable<Car> {
    private final UUID id;
    private final AutoBrand brand;
    private final int year;
    private int mileage;
    private int price;

    public Car(UUID id, AutoBrand brand, int year, int mileage, int price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public AutoBrand getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
                mileage == car.mileage &&
                price == car.price &&
                brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year, mileage, price);
    }

    @Override
    public int compareTo(Car compCar) {
        return Integer.compare(compCar.getPrice(), this.getPrice());
    }
}
