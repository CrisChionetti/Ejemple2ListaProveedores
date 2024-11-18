package com.ejemple2.controlador;


import com.ejemple2.entidad.Proveedor;
import com.ejemple2.servicio.ProveedorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProveedorControlador {

    private final ProveedorServicio servicio;

    public ProveedorControlador(ProveedorServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", servicio.listarTodosLosProveedores());
        return "list-proveedores";
    }

    @GetMapping("/proveedores/nuevo")
    public String mostrarFormularioDeNuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "form-proveedor";
    }

    @PostMapping("/proveedores")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        servicio.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/{id}/editar")
    public String editarProveedor(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", servicio.obtenerProveedorPorId(id));
        return "form-proveedor";
    }

    @PostMapping("/proveedores/{id}")
    public String actualizarProveedor(@PathVariable Long id, @ModelAttribute Proveedor proveedor) {
        proveedor.setIdProveedor(id);
        servicio.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/{id}/eliminar")
    public String eliminarProveedor(@PathVariable Long id) {
        servicio.eliminarProveedor(id);
        return "redirect:/proveedores";
    }
}
