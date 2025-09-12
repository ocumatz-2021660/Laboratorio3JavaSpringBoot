package com.oscarcumatzl.SportStore.controller;


import com.oscarcumatzl.SportStore.model.User;
import com.oscarcumatzl.SportStore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getALLUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        User result = userService.saveUser(user);
        if ("correoCorrecto".equals(result.getEmail())) {
            return "El correo debe ser de dominio @gmail.com";
        }
        if ("NombresDuplicados".equals(result.getFirstName())) {
            return "el nombre ya existe en los registros ";
        }
        if ("CorreoDuplicado".equals(result.getEmail())) {
            return "el corrreo electronico ya esta en uso";
        }
        return "Nuevo usuario: AGREGADO";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        User buscarUsuario = userService.updateUser(id, user);
        if ("correoCorrecto".equals(buscarUsuario.getEmail())) {
            return "El correo debe ser de dominio @gmail.com";
        }
        if("NombresExisten".equals((buscarUsuario.getFirstName()))){
            return "el nombre ya esta registrado";
        }
        if("correoExiste".equals(buscarUsuario.getEmail())){
            return "el correo ya esta en uso";
        }
        if (buscarUsuario == null) {
            return "No existe el usuario seleccionado";
        }
        return "Usuario: ACTUALIZADO";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean eliminado = userService.deleteUser(id);
        if (eliminado) {
            return "Usuario eliminado con éxito";
        } else {
            return "La id seleccionada no existe";
        }
    }

}
