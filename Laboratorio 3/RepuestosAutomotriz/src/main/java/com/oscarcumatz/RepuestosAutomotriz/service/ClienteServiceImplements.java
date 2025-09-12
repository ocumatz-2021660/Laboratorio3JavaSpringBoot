package com.oscarcumatz.RepuestosAutomotriz.service;

import ch.qos.logback.core.net.server.Client;
import com.oscarcumatz.RepuestosAutomotriz.models.Cliente;
import com.oscarcumatz.RepuestosAutomotriz.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImplements implements  ClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(int codigoCliente) {
        return clienteRepository.findById(codigoCliente).orElse(null);
    }


    @Override
    public Cliente guardarCliente(Cliente cliente) {
       if(cliente.getCorreoCliente() == null || !cliente.getCorreoCliente().toLowerCase().endsWith("@gmail.com")){
           cliente.setCorreoCliente("formatoCorreo");
           return cliente;
       }
       List<Cliente> listaClientes = clienteRepository.findAll();
       for (Cliente clienteExiste : listaClientes){
           if(clienteExiste.getNombreCliente().equalsIgnoreCase(cliente.getNombreCliente()) && clienteExiste.getApellidoCliente().equalsIgnoreCase(cliente.getApellidoCliente())){
               cliente.setNombreCliente("NombreEnUso");
               return cliente;
           }
           if(clienteExiste.getCorreoCliente().equalsIgnoreCase(cliente.getCorreoCliente())){
               cliente.setCorreoCliente("CorreoEnUso");
               return cliente;
           }
           if(clienteExiste.getTelefonoCliente().equalsIgnoreCase(cliente.getTelefonoCliente())){
               cliente.setTelefonoCliente("TelefonoEnUso");
               return cliente;
           }
       }
       return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(int codigoCliente, Cliente cliente) {
        Cliente clienteAct = clienteRepository.findById(codigoCliente).orElse(null);
        if (clienteAct != null){
            if(cliente.getCorreoCliente() == null || !cliente.getCorreoCliente().toLowerCase().endsWith("@gmail.com")){
                cliente.setCorreoCliente("formatoCorreo");
                return cliente;
            }
            List<Cliente> listaClientes = clienteRepository.findAll();
            for (Cliente clienteExiste : listaClientes){
                if(clienteExiste.getNombreCliente().equalsIgnoreCase(cliente.getNombreCliente()) && clienteExiste.getApellidoCliente().equalsIgnoreCase(cliente.getApellidoCliente())){
                    cliente.setNombreCliente("NombreEnUso");
                    return cliente;
                }
                if(clienteExiste.getCorreoCliente().equalsIgnoreCase(cliente.getCorreoCliente())){
                    cliente.setCorreoCliente("CorreoEnUso");
                    return cliente;
                }
                if(clienteExiste.getTelefonoCliente().equalsIgnoreCase(cliente.getTelefonoCliente())){
                    cliente.setTelefonoCliente("TelefonoEnUso");
                    return cliente;
                }
            }
            clienteAct.setNombreCliente(cliente.getNombreCliente());
            clienteAct.setApellidoCliente(cliente.getApellidoCliente());
            clienteAct.setCorreoCliente(cliente.getCorreoCliente());
            clienteAct.setTelefonoCliente(cliente.getTelefonoCliente());
            return clienteRepository.save(clienteAct);
        }
        return null;
    }

    @Override
    public boolean borrarCliente(int codigoCliente){
        if(clienteRepository.existsById(codigoCliente)){
            clienteRepository.deleteById(codigoCliente);
            return true;
        }
        return false;
    }
}
