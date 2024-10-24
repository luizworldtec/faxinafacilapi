package br.com.faxinafacil.models.servicodefaxina;

public record ServicoDeFaxinaResponse(String enderecoServico , String dataHoraPgto) {
    public ServicoDeFaxinaResponse(ServicoDeFaxina servicoDeFaxina) {this(servicoDeFaxina.getEnderecoServico(),servicoDeFaxina.getDataHoraPgto());}
}
