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
public class Pagamento {
    private String valorPgto;
    private String dataHoraPgto;
    private String typePayment;
    private String statusPgto;
}