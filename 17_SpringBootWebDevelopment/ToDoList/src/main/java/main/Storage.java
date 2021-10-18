package main;

import response.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private static AtomicInteger currentId = new AtomicInteger(0);
    private static Map<Integer, Car> cars = new ConcurrentHashMap<>();

    public static List<Car> getAllCars(){
        return new ArrayList<>(cars.values());
    }

    public static int addCar(Car car){
        int id = currentId.incrementAndGet();
        int year = (int) (2000 + Math.random() * (2021 - 2000));
        car.setId(id);
        car.setName("Car" + id);
        car.setYear(year);
        cars.put(id, car);
        return id;
    }

    public static void updateAllCars(){
        cars.forEach((integer, car) -> car.setName(car.getName().concat("(Updated name)")));
    }

    public static void deleteAllCars(){
        cars.clear();
    }

    public static Car getCar(int carId){
        if(cars.containsKey(carId)){
            return cars.get(carId);
        }
        return null;
    }

    public static void updateCar(Car car){
        car.setName(car.getName().concat("(Update the name of this vehicle)"));
        car.setYear(car.getYear() + 1);
    }

    public static void deleteCar(int id){
        cars.remove(id);
    }

}
