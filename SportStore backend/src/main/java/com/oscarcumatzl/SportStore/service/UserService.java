package com.joabregil.Ejemplo1.service;


import com.joabregil.Ejemplo1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);

}
