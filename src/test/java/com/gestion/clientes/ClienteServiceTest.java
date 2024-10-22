package com.gestion.clientes;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gestion.clientes.entity.Cliente;
import com.gestion.clientes.repository.ClienteRepository;
import com.gestion.clientes.service.ClienteService;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setClienteId("12345");
        cliente.setContrasena("password");
        cliente.setEstado(true);

        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente clienteGuardado = clienteService.guardar(cliente);
        assertEquals("Juan", clienteGuardado.getNombre());
        assertEquals("12345", clienteGuardado.getClienteId());
    }


    @Test
    public void testObtenerClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Carlos");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.obtenerPorId(1L);
        assertEquals("Carlos", clienteEncontrado.getNombre());
    }

 
    @Test
    public void testClienteNoEncontrado() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteService.obtenerPorId(1L);
        });

        assertEquals("Cliente con ID 1 no encontrado", exception.getMessage());
    }
}
