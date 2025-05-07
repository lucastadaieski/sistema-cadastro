package lucastadaieski.sistema_cadastro.model;

public class BuilderUsuario {
    private String nome, email, telefone, endereco;

    public BuilderUsuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BuilderUsuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public BuilderUsuario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public BuilderUsuario setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public Usuario buildComum() {
        return new UsuarioComum(nome, email, telefone, endereco);
    }

    public Usuario buildAdministrador() {
        return new UsuarioAdministrador(nome, email, telefone, endereco);
    }
}