package br.com.faxinafacil.models.usuario;

public record UsuarioResponse(String nome, String endereco) {

    public UsuarioResponse(Usuario usuario){
        this(usuario.getNome(), usuario.getEndereco());
    }
}
