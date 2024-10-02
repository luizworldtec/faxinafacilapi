package br.com.faxinafacil.models;

import jakarta.persistence.Entity;

@Entity
public class Usuario {
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String historicoLimpezas;
    private String cpf;
}
