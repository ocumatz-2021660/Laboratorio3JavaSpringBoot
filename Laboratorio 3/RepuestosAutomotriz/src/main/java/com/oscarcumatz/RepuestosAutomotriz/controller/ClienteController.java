package com.oscarcumatz.RepuestosAutomotriz.controller;

import com.oscarcumatz.RepuestosAutomotriz.models.Cliente;
import com.oscarcumatz.RepuestosAutomotriz.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }
    @GetMapping ("/{codigoCliente}")
    public Cliente getClienteById(@PathVariable int codigoCliente){
        return clienteService.getClienteById(codigoCliente);
    }
    @PostMapping
    public String guardarCliente(@RequestBody Cliente cliente){
        Cliente newCliente = clienteService.guardarCliente(cliente);
        if("formatoCorreo".equals(newCliente.getCorreoCliente())){
            return "El correo debe seguir el formato @gmail.com";
        }
        if("NombreEnUso".equals(newCliente.getNombreCliente())){
            return "el nombre ya esta en uso intente otro";
        }
        if("CorreoEnUso".equals(newCliente.getCorreoCliente())){
            return "el correo ya esta en uso intente otro";
        }
        if("TelefonoEnUso".equals(newCliente.getTelefonoCliente())){
            return "el numero de telefono ya esta en uso intente otro";
        }
        return "Cliente agregao";
    }
    @PutMapping("/{codigoCliente}")
    public String actualizarCliente(@PathVariable int codigoCliente, @RequestBody Cliente cliente){
        Cliente updateCliente = clienteService.actualizarCliente(codigoCliente, cliente);
        if(updateCliente == null){
            return "El cliente no existe en los registros";
        }
        if("formatoCorreo".equals(updateCliente.getCorreoCliente())){
            return "El correo debe seguir el formato @gmail.com";
        }
        if("NombreEnUso".equals(updateCliente.getNombreCliente())){
            return "el nombre ya esta en uso intente otro";
        }
        if("CorreoEnUso".equals(updateCliente.getCorreoCliente())){
            return "el correo ya esta en uso intente otro";
        }
        if("TelefonoEnUso".equals(updateCliente.getTelefonoCliente())){
            return "el numero de telefono ya esta en uso intente otro";
        }
        return "Cliente actualizado";
    }
    @DeleteMapping ("/{codigoCliente}")
    public String borrarCliente(@PathVariable int codigoCliente){
        boolean clienteEliminado = clienteService.borrarCliente(codigoCliente);
        if (clienteEliminado){
            return "Cliente eliminado del registro";
        }else{
            return "El cliente no existe en los registros";
        }
    }
}
