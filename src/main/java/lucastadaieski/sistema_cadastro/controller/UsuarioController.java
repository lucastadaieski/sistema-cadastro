package lucastadaieski.sistema_cadastro.controller;

import lucastadaieski.sistema_cadastro.factory.UsuarioAdministradorFactory;
import lucastadaieski.sistema_cadastro.factory.UsuarioComumFactory;
import lucastadaieski.sistema_cadastro.factory.UsuarioFactory;
import lucastadaieski.sistema_cadastro.model.BuilderUsuario;
import lucastadaieski.sistema_cadastro.model.TipoUsuario;
import lucastadaieski.sistema_cadastro.model.Usuario;
import lucastadaieski.sistema_cadastro.model.UsuarioComum;
import lucastadaieski.sistema_cadastro.repository.UsuarioRepository;
import lucastadaieski.sistema_cadastro.singleton.RepositorioUsuarios;

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
        model.addAttribute("usuario", new UsuarioComum());
        model.addAttribute("tipos", TipoUsuario.values());
        return "form-usuario";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuarioComum usuario){
        BuilderUsuario builder = new BuilderUsuario()
                .setNome(usuario.getNome())
                .setEmail(usuario.getEmail())
                .setTelefone(usuario.getTelefone())
                .setEndereco(usuario.getEndereco());

        UsuarioFactory factory = usuario.getTipo() == TipoUsuario.ADMINISTRADOR
                ? new UsuarioAdministradorFactory()
                : new UsuarioComumFactory();

        Usuario novoUsuario = factory.criarUsuario(builder);

        RepositorioUsuarios.getInstancia().adicionar(novoUsuario);

        usuarioRepository.save(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        UsuarioComum usuario = (UsuarioComum) usuarioRepository.findById(id)
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

        if(termo.matches("\\d+")){
            Optional<Usuario> usuario = usuarioRepository.findById(Long.parseLong(termo));
            resultados = usuario.map(List::of).orElse(List.of());
        } else {
            resultados = usuarioRepository.findByNomeContainingIgnoreCase(termo);
        }

        model.addAttribute("usuarios", resultados);
        return "lista-usuarios";
    }
}
