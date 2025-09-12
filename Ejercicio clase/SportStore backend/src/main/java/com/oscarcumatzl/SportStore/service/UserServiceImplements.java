package com.oscarcumatzl.SportStore.service;


import com.oscarcumatzl.SportStore.model.User;
import com.oscarcumatzl.SportStore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplements implements UserService{

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
        if (user.getEmail() == null || !user.getEmail().toLowerCase().endsWith("@gmail.com")) {
            user.setEmail("correoCorrecto");
            return user;
        }
        List<User> listaUsuarios = userRepository.findAll();
        for (User usuarioExistente : listaUsuarios) {
            if (usuarioExistente.getFirstName().equalsIgnoreCase(user.getFirstName()) && usuarioExistente.getLastName().equalsIgnoreCase(user.getLastName())) {
                user.setFirstName("NombresDuplicados");
                return user;
            }
            if (usuarioExistente.getEmail().equalsIgnoreCase(user.getEmail())) {
                user.setEmail("CorreoDuplicado");
                return user;
            }
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            if (user.getEmail() == null || !user.getEmail().toLowerCase().endsWith("@gmail.com")) {
                user.setEmail("correoCorrecto");
                return user;
            }
            List<User> listaUsuarios = userRepository.findAll();
            for (User usuarioExistente : listaUsuarios) {
                if (!usuarioExistente.getId().equals(id)) {
                    if (usuarioExistente.getFirstName().equalsIgnoreCase(user.getFirstName()) &&
                            usuarioExistente.getLastName().equalsIgnoreCase(user.getLastName())) {
                        user.setFirstName("NombresExisten");
                        return user;
                    }
                    if (usuarioExistente.getEmail().equalsIgnoreCase(user.getEmail())) {
                        user.setEmail("correoExiste");
                        return user;
                    }
                }
            }

            // Si pasa las validaciones, actualizamos
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}