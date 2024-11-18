package com.ejemple2.servicio;


import com.ejemple2.entidad.Proveedor;
import com.ejemple2.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    private final ProveedorRepository repositorio;

    public ProveedorServicioImpl(ProveedorRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Proveedor> listarTodosLosProveedores() {
        return repositorio.findAll();
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return null;
    }


    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarProveedor(Long id) {
        repositorio.deleteById(id);
    }
}

