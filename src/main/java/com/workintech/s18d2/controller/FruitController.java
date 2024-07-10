package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/fruits")
public class FruitController {

    private final FruitServiceImpl fruitService;

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/")
    public List<Fruit> getByPriceAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/search/{name}")
    public List<Fruit> searchByName(@Positive @PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable Long id) {
        return fruitService.getById(id);
    }

    @PostMapping("/")
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable Long id) {
        return fruitService.delete(id);
    }


}
