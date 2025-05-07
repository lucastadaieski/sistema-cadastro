package lucastadaieski.sistema_cadastro.factory;

import lucastadaieski.sistema_cadastro.model.BuilderUsuario;
import lucastadaieski.sistema_cadastro.model.Usuario;

public class UsuarioAdministradorFactory extends UsuarioFactory {
    public Usuario criarUsuario(BuilderUsuario builder) {
        return builder.buildAdministrador();
    }
}
