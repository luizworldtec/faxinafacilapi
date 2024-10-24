package br.com.faxinafacil.models.usuario;

import br.com.faxinafacil.models.servicodefaxina.ServicoDeFaxina;
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
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String numTel;
    private String historicoLimpezas;
    @ManyToOne
    @JoinColumn(name = "servicoDeFaxina_id")
    private ServicoDeFaxina servicoDeFaxina;
}