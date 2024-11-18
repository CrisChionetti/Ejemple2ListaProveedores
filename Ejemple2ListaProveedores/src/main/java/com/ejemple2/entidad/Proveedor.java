package com.ejemple2.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String sitioWeb;
    private Integer estado;
}
