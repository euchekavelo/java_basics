package main;

import main.model.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    CarRepository carRepository;

    /**
     * Получение списка всех машин.
     */
    @GetMapping("/cars")
    public ResponseEntity<?> getCarsList(){
        Iterable<Car> carIterable = carRepository.findAll();
        List<Car> carsList = new ArrayList<>();
        carIterable.forEach(carsList::add);
        if (carsList.isEmpty()){
            return new ResponseEntity<>("Список машин пуст.", HttpStatus.OK);
        }
        return new ResponseEntity<>(carsList, HttpStatus.OK);
    }

    /**
     * Добавление машины.
     */
    @PostMapping("/cars")
    public ResponseEntity<Integer> addCar(Car car){
        car.setName("Car");
        car.setYear(1994);
        Car newCar = carRepository.save(car);
        return new ResponseEntity<>(newCar.getId(), HttpStatus.OK);
    }

    /**
     * Обновление наименования у всех машин.
     */
    @PutMapping("/cars")
    public ResponseEntity<String> updateAllCars(){
        Iterable<Car> carIterable = carRepository.findAll();
        List<Car> carList = new ArrayList<>();
        carIterable.forEach(carList::add);
        if (carList.isEmpty()){
            return new ResponseEntity<>("Невозможно провести обновление списка машин (список пуст).",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
        carIterable.forEach(car -> {
            String newCarName = car.getName() + "(Updated name)";
            car.setName(newCarName);
        });
        carRepository.saveAll(carIterable);
        return new ResponseEntity<>("Наименование всех машин обновлено (добавлено \"(Updated name)\")",
                HttpStatus.OK);
    }

    /**
     * Удаление всех машин.
     */
    @DeleteMapping("/cars")
    public ResponseEntity<String> deleteAllCars(){
        carRepository.deleteAll();
        return new ResponseEntity<>("Выполнено удаление всех машин из списка.", HttpStatus.OK);
    }

    /**
     * Получение конкретной машины по id.
     */
    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable int id){
        Optional<Car> carOptional = carRepository.findById(id);
        if (!carOptional.isPresent()){
            return new ResponseEntity<>("Машина с указанным id не найдена.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
    }

    /**
     * Добавление машины, указывая конкретный id.
     */
    @PostMapping("/cars/{id}")
    public ResponseEntity<String> addACarUsingASpecificId(){
        return new ResponseEntity<>("Метод не разрешен.", HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Обновление данных у машины с конкретным id.
     */
    @PutMapping("/cars/{id}")
    public ResponseEntity<String> updateCar(@PathVariable int id){
        Optional<Car> carOptional = carRepository.findById(id);
        if (!carOptional.isPresent()){
            return new ResponseEntity<>("Обновление не выполнено. Машина с указанным id не найдена.",
                    HttpStatus.NOT_FOUND);
        }

        //обновляем параметры машины
        Car updatedCar = carOptional.get();
        updatedCar.setName(updatedCar.getName() + "(Single update)");
        updatedCar.setYear(2021);
        carRepository.save(updatedCar);

        return new ResponseEntity<>("Обновление данных машины с указанным id успешно выполнено.",
                HttpStatus.OK);
    }

    /**
     * Удаление существующей машины по id.
     */
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id){
        Optional<Car> carOptional = carRepository.findById(id);
        if (!carOptional.isPresent()){
            return new ResponseEntity<>("Удаление невозможно. Машина с указанным id не найдена.",
                    HttpStatus.NOT_FOUND);
        }
        carRepository.deleteById(id);
        return new ResponseEntity<>("Удаление машины с указанным id успешно выполнено.",
                HttpStatus.OK);
    }
}
