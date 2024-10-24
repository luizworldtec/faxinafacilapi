package br.com.faxinafacil.models.pagamento;

import jakarta.validation.constraints.NotBlank;

public record PagamentoRequest(@NotBlank
                               Long id,
                               @NotBlank
                               String Valorpgto,
                               @NotBlank
                               String dataHorapgto,
                               @NotBlank
                               String typePayment,
                               @NotBlank
                               String statusPgto) {
    public Pagamento toPagamento(){
        return new Pagamento(id(), Valorpgto(),dataHorapgto(), typePayment(), statusPgto(), null);
    }
}
