package com.gestion.clientes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.clientes.entity.Cliente;
import com.gestion.clientes.exception.ClienteExistenteException;
import com.gestion.clientes.exception.ClienteNoEncontradoException;
import com.gestion.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardar(Cliente cliente) {
        boolean existe = clienteRepository.existsByClienteId(cliente.getClienteId());
        if (existe) {
            throw new ClienteExistenteException("Ya existe un cliente con el ID " + cliente.getClienteId());
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ClienteNoEncontradoException("Cliente con ID " + id + " no encontrado"));
    }

    public void eliminar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ClienteNoEncontradoException("Cliente con ID " + id + " no encontrado"));
        clienteRepository.deleteById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = obtenerPorId(id);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setGenero(clienteActualizado.getGenero());
        clienteExistente.setEdad(clienteActualizado.getEdad());
        clienteExistente.setIdentificacion(clienteActualizado.getIdentificacion());
        clienteExistente.setDireccion(clienteActualizado.getDireccion());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setContrasena(clienteActualizado.getContrasena());
        clienteExistente.setEstado(clienteActualizado.isEstado());

        return clienteRepository.save(clienteExistente);
    }
}
