package com.ejemple2.controlador;


import com.ejemple2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Muestra el formulario de login.
     *
     * @return Nombre de la vista de login
     */
    @GetMapping("/login")
    public String mostrarFormularioDeLogin() {
        return "login"; // Archivo HTML en src/main/resources/templates/login.html
    }

    /**
     * Procesa el formulario de login.
     *
     * @param nombre   Nombre de usuario ingresado
     * @param password Contraseña ingresada
     * @param model    Modelo para pasar atributos a la vista
     * @return Redirección o vista del login
     */
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre,
                                @RequestParam String password,
                                Model model) {
        System.out.println("Datos recibidos: Nombre = " + nombre + ", Password = " + password);

        // Valida el usuario con el servicio
        if (usuarioService.validarUsuario(nombre, password)) {
            // Redirige al listado de proveedores si el login es exitoso
            return "redirect:/proveedores";
        }

        // Si falla el login, muestra un mensaje de error
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login"; // Devuelve a la misma vista con el mensaje de error
    }
}
