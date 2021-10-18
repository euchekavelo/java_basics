package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Car;

import java.util.List;

@RestController
public class CarController {

    /**
     * Получение списка всех машин.
     */
    @GetMapping("/cars")
    public ResponseEntity<?> getCarsList(){
        List<Car> carsList = Storage.getAllCars();
        if (carsList.isEmpty()){
            return new ResponseEntity<>("Список машин пуст.", HttpStatus.OK);
        }
        return new ResponseEntity<>(Storage.getAllCars(), HttpStatus.OK);
    }

    /**
     * Добавление машины.
     */
    @PostMapping("/cars")
    public ResponseEntity<Integer> addCar(Car car){
        return new ResponseEntity<>(Storage.addCar(car), HttpStatus.OK);
    }

    /**
     * Обновление наименования у всех машин.
     */
    @PutMapping("/cars")
    public ResponseEntity<String> updateAllCars(){
        List<Car> carsList = Storage.getAllCars();
        if (carsList.isEmpty()){
            return new ResponseEntity<>("Невозможно провести обновление списка машин (список пуст).",
                    HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            Storage.updateAllCars();
            return new ResponseEntity<>("Наименование всех машин обновлено (добавлено \"(Updated name)\")",
                    HttpStatus.OK);
        }
    }

    /**
     * Удаление всех машин.
     */
    @DeleteMapping("/cars")
    public ResponseEntity<String> deleteAllCars(){
        Storage.deleteAllCars();
        return new ResponseEntity<>("Выполнено удаление всех машин из списка.", HttpStatus.OK);
    }

    /**
     * Получение конкретной машины по id.
     */
    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable int id){
        Car car = Storage.getCar(id);
        if (car == null){
            return new ResponseEntity<>("Машина с указанным id не найдена.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
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
        Car car = Storage.getCar(id);
        if (car == null){
            return new ResponseEntity<>("Обновление не выполнено. Машина с указанным id не найдена.",
                    HttpStatus.NOT_FOUND);
        } else {
            Storage.updateCar(car);
            return new ResponseEntity<>("Обновление данных машины с указанным id успешно выполнено.",
                    HttpStatus.OK);
        }
    }

    /**
     * Удаление существующей машины по id.
     */
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id){
        Car car = Storage.getCar(id);
        if (car == null){
            return new ResponseEntity<>("Удаление невозможно. Машина с указанным id не найдена.",
                    HttpStatus.NOT_FOUND);
        } else {
            Storage.deleteCar(id);
            return new ResponseEntity<>("Удаление машины с указанным id успешно выполнено.",
                    HttpStatus.OK);
        }
    }
}
