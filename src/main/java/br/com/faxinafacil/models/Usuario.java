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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String historicoLimpezas;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "servicoDeFaxina_id")
    private ServicoDeFaxina servicoDeFaxina;
}