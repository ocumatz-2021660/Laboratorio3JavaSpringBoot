package com.joabregil.Ejemplo1.service;


import com.joabregil.Ejemplo1.model.User;
import com.joabregil.Ejemplo1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplements(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existinUser = userRepository.findById(id).orElse(null);
        if (existinUser!= null){
            existinUser.setFirstName(user.getFirstName());
            existinUser.setLastName(user.getLastName());
            existinUser.setEmail(user.getEmail());
            return userRepository.save(existinUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
