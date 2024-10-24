package br.com.faxinafacil.models.avaliacao;

import jakarta.validation.constraints.NotBlank;

public record AvaliacaoRequest(@NotBlank
                               Long id,
                               @NotBlank
                               String comentarioServico,
                               @NotBlank
                               String classifEstrelas,
                               @NotBlank
                               String dataHoraAvaliacao) {

    public Avaliacao toAvaliacao(){
        return new Avaliacao(id(), comentarioServico(), classifEstrelas(), dataHoraAvaliacao(), null);
    }
}
