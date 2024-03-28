package org.example.finalproject.service;

import org.example.finalproject.entity.*;

import java.util.*;

public interface UserService {

     User createUser(User user);
     Optional<User> getUserById(Long id);
     List<User> getAllUsers();
     void deleteAllUsers();
     void deleteById(Long id);
     User updateById(User user, Long id);
     User updatePartialUser(User user, Long id);
}
