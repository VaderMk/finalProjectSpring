package org.example.finalproject.service;

import org.example.finalproject.entity.*;
import org.example.finalproject.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateById(User user, Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()) {
            User updateUser = foundUser.get();
            updateUser.setEmail(user.getEmail());
            updateUser.setFullName(user.getFullName());
            updateUser.setPassword(user.getPassword());
            return userRepository.save(updateUser);
        }
        return null;
    }

    @Override
    public User updatePartialUser(User user, Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if(foundUser.isEmpty()){
            return null;
        }
        User existentUser = foundUser.get();
        if(user.getEmail() != null){
            existentUser.setEmail(user.getEmail());
        }
        if(user.getPassword() != null){
            existentUser.setPassword(user.getPassword());
        }
        if(user.getFullName() != null){
            existentUser.setFullName(user.getFullName());
        }
        return existentUser;
    }
}
