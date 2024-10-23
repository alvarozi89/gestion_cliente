package com.gestion.clientes;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestion.clientes.entity.Cliente;
import com.gestion.clientes.repository.ClienteRepository;
import com.gestion.clientes.service.ClienteService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ClienteServiceIntegrationTest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @Transactional
    public void testGuardarYObtenerCliente() {
       
        Cliente cliente = new Cliente();
        cliente.setNombre("Pedro");
        cliente.setClienteId("cliente123");
        cliente.setContrasena("123456");

        Cliente clienteGuardado = clienteService.guardar(cliente);
        assertNotNull(clienteGuardado.getId());

        Optional<Cliente> clienteObtenido = clienteRepository.findById(clienteGuardado.getId());
        assertTrue(clienteObtenido.isPresent());
        assertEquals("Pedro", clienteObtenido.get().getNombre());
    }
}