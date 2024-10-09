package br.com.faxinafacil.services;

import br.com.faxinafacil.exceptions.PagamentoInvalidoException;
import br.com.faxinafacil.models.Pagamento;
import br.com.faxinafacil.repositories.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento enviarPagamento(Pagamento pagamento) {
        validarPagamento(pagamento);
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long cod) {
        return pagamentoRepository.findById(cod).orElseThrow(() ->
                new PagamentoInvalidoException("Pagamento não encontrado com o ID: " + cod));
    }

    public void deletarPagamento(Long cod) {
        if (!pagamentoRepository.existsById(cod)) {
            throw new PagamentoInvalidoException("Pagamento não encontrado com o ID: " + cod);
        }
        pagamentoRepository.deleteById(cod);
    }

    public boolean existePagamento(Long cod) {
        return pagamentoRepository.existsById(cod);
    }

    private void validarPagamento(Pagamento pagamento) {
        if (pagamento.getValorPgto() == null || pagamento.getValorPgto().isEmpty()) {
            throw new PagamentoInvalidoException("O valor do pagamento não pode ser nulo ou vazio.");
        }
        if (pagamento.getDataHoraPgto() == null) {
            throw new PagamentoInvalidoException("A data e hora do pagamento não podem ser nulas.");
        }
        if (pagamento.getTypePayment() == null || pagamento.getTypePayment().isEmpty()) {
            throw new PagamentoInvalidoException("O tipo de pagamento não pode ser nulo ou vazio.");
        }
        if (pagamento.getStatusPgto() == null || pagamento.getStatusPgto().isEmpty()) {
            throw new PagamentoInvalidoException("O status do pagamento não pode ser nulo ou vazio.");
        }
    }
}
