package br.com.faxinafacil.services;

import br.com.faxinafacil.exceptions.ServicoInvalidoException;
import br.com.faxinafacil.models.ServicoDeFaxina;
import br.com.faxinafacil.repositories.ServicoDeFaxinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeFaxinaService {

    private final ServicoDeFaxinaRepository servicoDeFaxinaRepository;

    public ServicoDeFaxinaService(ServicoDeFaxinaRepository servicoDeFaxinaRepository) {
        this.servicoDeFaxinaRepository = servicoDeFaxinaRepository;
    }

    public ServicoDeFaxina salvarServico(ServicoDeFaxina servico) {
        validarServico(servico);
        return servicoDeFaxinaRepository.save(servico);
    }

    public ServicoDeFaxina buscarPorId(Long id) {
        return servicoDeFaxinaRepository.findById(id).orElseThrow(() ->
                new ServicoInvalidoException("Serviço de faxina não encontrado com o ID: " + id));
    }

    public void deletarServico(Long id) {
        if (!servicoDeFaxinaRepository.existsById(id)) {
            throw new ServicoInvalidoException("Serviço de faxina não encontrado com o ID: " + id);
        }
        servicoDeFaxinaRepository.deleteById(id);
    }

    public boolean existeServico(Long id) {
        return servicoDeFaxinaRepository.existsById(id);
    }

    public List<ServicoDeFaxina> listarTodos() {
        return servicoDeFaxinaRepository.findAll();
    }

    private void validarServico(ServicoDeFaxina servico) {
        if (servico.getDataHoraPgto() == null || servico.getDataHoraPgto().isEmpty()) {
            throw new ServicoInvalidoException("A data e hora do pagamento não podem ser nulas ou vazias.");
        }
        if (servico.getEnderecoServico() == null || servico.getEnderecoServico().isEmpty()) {
            throw new ServicoInvalidoException("O endereço do serviço não pode ser nulo ou vazio.");
        }
        // Adicione mais validações conforme necessário
    }
}
