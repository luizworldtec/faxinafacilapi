package br.com.faxinafacil.services;

import br.com.faxinafacil.models.Avaliacao;
import br.com.faxinafacil.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao enviarAvalicao(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao buscarPorId(Long codigo){
        return avaliacaoRepository.findById(codigo).orElse(null);
    }

    public void deletarAvaliacao (Long codigo){
        avaliacaoRepository.deleteById(codigo);
    }

    public boolean existeAvaliacao (Long codigo){
        return !avaliacaoRepository.existsById(codigo);
    }
}
