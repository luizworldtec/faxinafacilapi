package br.com.faxinafacil.models;

import jakarta.persistence.Entity;

@Entity
public class Pagamento {
    private String valorPgto;
    private String dataHoraPgto;
    private String typePayment;
    private String statusPgto;
}
