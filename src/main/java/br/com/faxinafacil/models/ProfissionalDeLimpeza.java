package br.com.faxinafacil.models;

import jakarta.persistence.Entity;

@Entity
public class ProfissionalDeLimpeza {
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String avaliacoesRecebidas;
    private String cpf;
}
