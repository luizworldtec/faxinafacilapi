package br.com.faxinafacil.models.servicodefaxina;

import jakarta.validation.constraints.NotBlank;

public record ServicoDeFaxinaRequest(@NotBlank
                                     Long id,
                                     @NotBlank
                                     String dataHoraPgto,
                                     @NotBlank
                                     String enderecoServico) {

    public ServicoDeFaxina toServicoDeFaxina() {
        return new ServicoDeFaxina(id(), dataHoraPgto(), enderecoServico(), null);

    }
}
