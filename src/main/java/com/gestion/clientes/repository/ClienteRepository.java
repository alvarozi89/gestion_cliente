package com.gestion.clientes.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.clientes.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByClienteId(String clienteId);
}
