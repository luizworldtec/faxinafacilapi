package br.com.faxinafacil.models.profissionaldelimpeza;

public record ProfissionalDeLimpezaResponse(String nome, String endereco, String numTel, String avaliacoesRecebidas) {
    public  ProfissionalDeLimpezaResponse(ProfissionalDeLimpeza profissionalDeLimpeza){this(profissionalDeLimpeza.getNome(),profissionalDeLimpeza.getEndereco(),profissionalDeLimpeza.getNumTel(),profissionalDeLimpeza.getAvaliacoesRecebidas());}
}
