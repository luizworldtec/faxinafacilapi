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
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentarioServico;
    private String classifEstrelas;
    private String dataHoraAvaliacao;
    @OneToMany
    private ProfissionalDeLimpeza profissionalDeLimpeza;
}