package br.com.faxinafacil.models;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String comentarioServico;
    @Column
    private String classifEstrelas;
    @Column
    private String dataHoraAvaliacao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
