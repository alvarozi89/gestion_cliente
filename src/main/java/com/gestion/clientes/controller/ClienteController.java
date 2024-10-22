package com.gestion.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.clientes.entity.Cliente;
import com.gestion.clientes.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerPorId(id);
    }

   @PostMapping("/create")
    public Cliente crearCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @PutMapping("/update/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente clienteActualizado) {
        return clienteService.actualizarCliente(id, clienteActualizado);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
