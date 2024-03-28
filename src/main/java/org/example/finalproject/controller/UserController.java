package org.example.finalproject.controller;

import org.example.finalproject.entity.*;
import org.example.finalproject.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUserEndpoint(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByIdEndpoint(@PathVariable Long id){
        if(userService.getUserById(id).isEmpty())
            return ResponseEntity.notFound().build();
        else{
            return ResponseEntity.ok(userService.getUserById(id).get());
        }
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsersEndpoint(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @DeleteMapping
    public void deleteAllUsersEndpoint(){
        userService.deleteAllUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserByIdEndpoint(@PathVariable Long id){
        if(userService.getUserById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        if(userService.getUserById(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userService.updateById(user, id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePartialUser(@PathVariable Long id, @RequestBody User user){
        if(userService.getUserById(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userService.updatePartialUser(user, id));
    }
}