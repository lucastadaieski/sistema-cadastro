package lucastadaieski.sistema_cadastro.model;

import jakarta.persistence.Entity;

@Entity
public class UsuarioAdministrador extends Usuario {

    public UsuarioAdministrador() {
        super();
    }

    public UsuarioAdministrador(String nome, String email, String telefone, String endereco) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
        setTipo(TipoUsuario.ADMINISTRADOR);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

}


