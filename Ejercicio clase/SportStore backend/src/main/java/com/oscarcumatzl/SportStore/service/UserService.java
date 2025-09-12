package com.oscarcumatzl.SportStore.service;


import com.oscarcumatzl.SportStore.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    boolean deleteUser(Integer id);



}
