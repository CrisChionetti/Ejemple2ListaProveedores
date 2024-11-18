package com.ejemple2.servicio;


import com.ejemple2.entidad.Proveedor;

import java.util.List;

public interface ProveedorServicio {
    List<Proveedor> listarTodosLosProveedores();
    Proveedor guardarProveedor(Proveedor proveedor);
    Proveedor obtenerProveedorPorId(Long id);
    void eliminarProveedor(Long id);
}

