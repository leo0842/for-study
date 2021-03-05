package com.example.demo.interfaces;

import com.example.demo.domain.Car;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

  List<Car> cars = new ArrayList<>();

  @GetMapping("/cars")
  public List<Car> list() {

    return cars;

  }

  @GetMapping("/cars/{carId}")
  public Car detail(@PathVariable("carId") Long carId) {

    return cars.get((int) (carId - 1));

  }

  @PostMapping("/cars")
  public String create(
      @RequestParam Long id, @RequestParam String name
  ) {

    cars.add(new Car(id, name));

    return "{}";

  }

  @PatchMapping("/cars/{carId}")
  public String update(
      @PathVariable("carId") Long carId,
      @RequestParam String name
  ) {
    Car car = cars.get((int) (carId - 1));
    car.setName(name);
    return "{}";
  }

  @DeleteMapping("/cars/{carId}")
  public String delete(@PathVariable("carId") Long carId) {

    cars.remove((int) (carId - 1));
    return "{}";

  }

}
