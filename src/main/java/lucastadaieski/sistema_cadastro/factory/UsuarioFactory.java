package lucastadaieski.sistema_cadastro.factory;

import lucastadaieski.sistema_cadastro.model.BuilderUsuario;
import lucastadaieski.sistema_cadastro.model.Usuario;

public abstract class UsuarioFactory {
    public abstract Usuario criarUsuario(BuilderUsuario builder);
}
