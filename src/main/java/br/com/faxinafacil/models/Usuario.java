package br.com.faxinafacil.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String historicoLimpezas;
    private String cpf;
}