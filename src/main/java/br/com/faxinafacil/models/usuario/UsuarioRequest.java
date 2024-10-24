package br.com.faxinafacil.models.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(@NotBlank
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
                             String historicoLimpezas) {

    public Usuario toUsuario(){
        return new Usuario(cpf(), nome(), endereco(), email(), numTel(), historicoLimpezas(), null);
    }

}
