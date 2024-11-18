package com.ejemple2.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera un constructor vacío.
@AllArgsConstructor // Genera un constructor con todos los campos.
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID.
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String passwordUsuario;
    }