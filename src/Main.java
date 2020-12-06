import Cars.AutoBrand;
import Cars.Car;
import Cars.CarsFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            cars.add(CarsFactory.getCar());
        }
        System.out.println("Init list of cars:");
        for (Car entry : cars) {
            System.out.println(entry);
        }

        List<Car> listFilteredCars = cars.stream().filter(car ->
                (car.getBrand().equals(AutoBrand.Audi) ||
                        car.getBrand().equals(AutoBrand.Tesla)) &&
                        car.getYear() > 2018 && car.getMileage() < 40000).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());

        long countFilteredCars = listFilteredCars.size();

        Map<UUID, Car> mapFilteredCars = listFilteredCars.stream().
                skip(countFilteredCars - 3).
                collect(Collectors.toMap(car -> car.getId(), car -> car));

        System.out.println("\n\rMap elements after filtering of stream:");
        for (Map.Entry<UUID, Car> entry : mapFilteredCars.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
