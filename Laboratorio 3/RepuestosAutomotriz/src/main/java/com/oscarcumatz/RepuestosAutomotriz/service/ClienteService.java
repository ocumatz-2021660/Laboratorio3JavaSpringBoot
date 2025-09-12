package com.oscarcumatz.RepuestosAutomotriz.service;
import com.oscarcumatz.RepuestosAutomotriz.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(int codigoCliente);
    Cliente guardarCliente (Cliente user);
    Cliente actualizarCliente (int codigoCliente, Cliente cliente);
    boolean borrarCliente(int codigoCliente);
}
