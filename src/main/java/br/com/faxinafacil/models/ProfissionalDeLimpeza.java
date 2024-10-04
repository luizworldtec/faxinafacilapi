package br.com.faxinafacil.models;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String avaliacoesRecebidas;
    private String cpf;
    @ManyToMany
    private Usuario usuario;
}