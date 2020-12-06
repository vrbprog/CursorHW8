import Cars.AutoBrand;
import Cars.Car;
import Cars.CarsFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cars.add(CarsFactory.getCar());
        }
        System.out.println("Init list of cars:");
        for (Car entry : cars) {
            System.out.println(entry);
        }

        Map<UUID, Car> carsFilter = cars.stream().filter(car ->
                (car.getBrand().equals(AutoBrand.Audi) ||
                        car.getBrand().equals(AutoBrand.Tesla)) &&
                        car.getYear() < 2018 && car.getMileage() < 40000).
                sorted().limit(3).collect(Collectors.toMap(car -> car.getId(), car -> car));

        System.out.println("\n\rMap elements after filtering of stream:");
        for (Map.Entry<UUID, Car> entry : carsFilter.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
