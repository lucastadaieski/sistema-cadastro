package lucastadaieski.sistema_cadastro.singleton;

import lucastadaieski.sistema_cadastro.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private static RepositorioUsuarios instancia;
    private List<Usuario> usuarios = new ArrayList<>();

    private RepositorioUsuarios() {}

    public static RepositorioUsuarios getInstancia(){
        if(instancia == null){
            instancia = new RepositorioUsuarios();
        }
        return instancia;
    }

    public void adicionar(Usuario usuario){
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }
}
