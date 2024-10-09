package br.com.faxinafacil.services;
import br.com.faxinafacil.models.Pagamento;
import br.com.faxinafacil.repositories.PagamentoRepository;
import org.springframework.stereotype.Service;


@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoService pagamentoService) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento enviarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long cod){
        return pagamentoRepository.findById(cod).orElse(null);
    }

    public void deletarPagamento(Long cod){
        pagamentoRepository.deleteById(cod);
    }

    public boolean existePagamento(Long cod){
        return !pagamentoRepository.existsById(cod);
    }

}
