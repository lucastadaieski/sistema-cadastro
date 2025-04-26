package lucastadaieski.sistema_cadastro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private  String nome;

    @Column(name = "tipo")
    private  String tipo;

    @Column(name = "email")
    private  String email;

    @Column(name = "telefone")
    private  String telefone;

    @Column(name = "endereco")
    private  String endereco;

}
