package br.com.faxinafacil.models.profissionaldelimpeza;

import jakarta.validation.constraints.NotBlank;

public record ProfissionalDeLimpezaRequest(@NotBlank
                                           String cpf,
                                           @NotBlank
                                           String nome,
                                           @NotBlank
                                           String endereco,
                                           @NotBlank
                                           String email,
                                           @NotBlank
                                           String numTel,
                                           @NotBlank
                                           String avaliacoesRecebidas) {
    public ProfissionalDeLimpeza toProfissionalDeLimpeza(){
        return new ProfissionalDeLimpeza(cpf(),nome(),endereco(),email(),numTel(),avaliacoesRecebidas(),null);
    }
}
