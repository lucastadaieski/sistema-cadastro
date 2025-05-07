package lucastadaieski.sistema_cadastro.model;

import jakarta.persistence.Entity;

@Entity
public class UsuarioComum extends Usuario {

    public UsuarioComum() {
        super();
    }

    public UsuarioComum(String nome, String email, String telefone, String endereco) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
        setTipo(TipoUsuario.COMUM);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.COMUM;
    }
}

