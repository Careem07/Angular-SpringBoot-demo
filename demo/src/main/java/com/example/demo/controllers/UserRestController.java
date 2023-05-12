package com.example.demo.controllers;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserRestController {

    @Autowired
    UserRepository repository;

    @GetMapping(value = "/userJson/{id}")
    public Optional<User> displayUserAsJson(@PathVariable int id) {
       return repository.findById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        repository.save(user);
    }

    @GetMapping("/users")
    public List<User> AllUsers(){
        List<User> users = repository.findAll();
        return users;
    }

    @GetMapping("one")
    public Optional<UserRepository.UserAbstraction> getUser(){
        return repository.findByName("kareem");
    }

    @GetMapping("two")
    public User getUser2(){
        return repository.findByNameAndId("xxx" , 15);
    }

//    @GetMapping("twotwo")
//    public Optional<User> getUser22(){
//
//        return repository.findById();
//    }

    @GetMapping("three")
    public List<User> getUser3(){
        return repository.findBySalaryGreaterThan("1000");
    }

    @GetMapping("users/page/{id}")
    public List<User> getUser4(@PathVariable int id){
        Pageable pageable = PageRequest.of(id, 5, Sort.by("name"));
        return repository.findAll(pageable).getContent();
//        return repository.findByIdBefore(4);
    }

    @PutMapping("user/update/{id}")
    public void updateUser(@PathVariable int id , @RequestBody User user){
         repository.setUser(user.getSalary(),id);

    }


    @GetMapping("/findall")
    public List<User> findAll(){
        return repository.getAllUsers();
    }

    @GetMapping("/remove/{id}")
    public void removeUserById(@PathVariable int id){
         repository.deleteById(id);
    }
}
