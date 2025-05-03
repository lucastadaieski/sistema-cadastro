package lucastadaieski.sistema_cadastro.repository;

import lucastadaieski.sistema_cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Essa interface herda os métodos CRUD prontos
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
