package br.com.faxinafacil.models.profissionaldelimpeza;

import br.com.faxinafacil.models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfissionalDeLimpeza {
    @Id
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String avaliacoesRecebidas;
    @ManyToMany
    private Usuario usuario;
}