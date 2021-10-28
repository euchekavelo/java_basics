package main;

import main.model.Car;
import main.model.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Car> carIterable = carRepository.findAll();
        List<Car> carsList = new ArrayList<>();
        carIterable.forEach(carsList::add);

        //Передадим в шаблон размер списка машин, а также сам список.
        model.addAttribute("countCars", carsList.size());
        model.addAttribute("carsList", carsList);
        return "index";
    }

}
