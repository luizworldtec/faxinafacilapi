package br.com.faxinafacil.services;

import br.com.faxinafacil.exceptions.AvaliacaoInvalidaException;
import br.com.faxinafacil.models.Avaliacao;
import br.com.faxinafacil.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public Avaliacao enviarAvaliacao(Avaliacao avaliacao) {
        validarAvaliacao(avaliacao);
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao buscarPorId(Long codigo) {
        return avaliacaoRepository.findById(codigo).orElseThrow(() ->
                new AvaliacaoInvalidaException("Avaliação não encontrada com o ID: " + codigo));
    }

    public void deletarAvaliacao(Long codigo) {
        if (!existeAvaliacao(codigo)) {
            throw new AvaliacaoInvalidaException("Avaliação não encontrada com o ID: " + codigo);
        }
        avaliacaoRepository.deleteById(codigo);
    }

    public boolean existeAvaliacao(Long codigo) {
        return avaliacaoRepository.existsById(codigo);
    }

    private void validarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao.getClassifEstrelas() == null) {
            throw new AvaliacaoInvalidaException("A classificação em estrelas não pode ser nula.");
        }
        if (avaliacao.getComentarioServico() == null || avaliacao.getComentarioServico().isEmpty()) {
            throw new AvaliacaoInvalidaException("O comentário do serviço não pode estar vazio.");
        }
    }
}
