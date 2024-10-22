package com.gestion.clientes.entity;





import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Cliente extends Persona {

    @Column(unique = true)
    private String clienteId;

    @NotNull(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @NotNull(message = "El estado del cliente es obligatorio")
    private boolean estado;
}
