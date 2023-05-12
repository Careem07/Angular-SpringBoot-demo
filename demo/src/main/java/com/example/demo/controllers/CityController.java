package com.example.demo.controllers;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityRepository repository ;

//    @GetMapping("/get")
//    Optional<City> getCity(){
//
//        return repository.findByCountryCode(new Country());
//    }

    @GetMapping("/page/{id}")
    List<City> getCityPage(@PathVariable int id) {

        Pageable pageable = PageRequest.of(id, 5, Sort.by("name"));
        return repository.findAll(pageable).getContent();
    }
}
