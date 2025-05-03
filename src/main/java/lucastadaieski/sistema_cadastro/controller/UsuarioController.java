package lucastadaieski.sistema_cadastro.controller;

import lucastadaieski.sistema_cadastro.model.TipoUsuario;
import lucastadaieski.sistema_cadastro.model.Usuario;
import lucastadaieski.sistema_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "lista-usuarios";
    }

    @GetMapping("/novo")
    public String  exibirFormulario(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tipos", TipoUsuario.values());
        return "form-usuario";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("usuario", usuario);
        model.addAttribute("tipos", TipoUsuario.values());
        return "form-usuario";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/buscar")
    public String buscarUsuarios(@RequestParam("termo") String termo, Model model) {
        List<Usuario> resultados;

        if (termo.matches("\\d+")) { // se for número, buscar por ID
            Optional<Usuario> usuario = usuarioRepository.findById(Long.parseLong(termo));
            resultados = usuario.map(List::of).orElse(List.of());
        } else {
            resultados = usuarioRepository.findByNomeContainingIgnoreCase(termo);
        }

        model.addAttribute("usuarios", resultados);
        return "lista-usuarios";
    }

}
