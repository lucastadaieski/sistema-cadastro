package lucastadaieski.sistema_cadastro.factory;

import lucastadaieski.sistema_cadastro.model.BuilderUsuario;
import lucastadaieski.sistema_cadastro.model.Usuario;

public class UsuarioComumFactory extends UsuarioFactory {
    public Usuario criarUsuario(BuilderUsuario builder) {
        return builder.buildComum();
    }
}
