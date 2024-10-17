package br.com.faxinafacil.services;

import br.com.faxinafacil.exceptions.ProfissionalInvalidoException;
import br.com.faxinafacil.models.ProfissionalDeLimpeza;
import br.com.faxinafacil.repositories.ProfissionalDeLimpezaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalDeLimpezaService {

    private final ProfissionalDeLimpezaRepository profissionalDeLimpezaRepository;

    public ProfissionalDeLimpezaService(ProfissionalDeLimpezaRepository profissionalDeLimpezaRepository) {
        this.profissionalDeLimpezaRepository = profissionalDeLimpezaRepository;
    }

    public ProfissionalDeLimpeza enviarProfissional(ProfissionalDeLimpeza profissional) {
        validarProfissional(profissional);
        return profissionalDeLimpezaRepository.save(profissional);
    }

    public ProfissionalDeLimpeza buscarPorCpf(String cpf) {
        return profissionalDeLimpezaRepository.findById(cpf).orElseThrow(() ->
                new ProfissionalInvalidoException("Profissional de limpeza não encontrado com o CPF: " + cpf));
    }

    public void deletarProfissional(String cpf) {
        if (!profissionalDeLimpezaRepository.existsById(cpf)) {
            throw new ProfissionalInvalidoException("Profissional de limpeza não encontrado com o CPF: " + cpf);
        }
        profissionalDeLimpezaRepository.deleteById(cpf);
    }

    public boolean existeProfissional(String cpf) {
        return profissionalDeLimpezaRepository.existsById(cpf);
    }

    private void validarProfissional(ProfissionalDeLimpeza profissional) {
        if (profissional.getCpf() == null || profissional.getCpf().isEmpty()) {
            throw new ProfissionalInvalidoException("O CPF do profissional não pode ser nulo ou vazio.");
        }
        if (profissional.getNome() == null || profissional.getNome().isEmpty()) {
            throw new ProfissionalInvalidoException("O nome do profissional não pode ser nulo ou vazio.");
        }
        if (profissional.getEmail() == null || profissional.getEmail().isEmpty()) {
            throw new ProfissionalInvalidoException("O email do profissional não pode ser nulo ou vazio.");
        }
        if (profissional.getNumTel() == null || profissional.getNumTel().isEmpty()) {
            throw new ProfissionalInvalidoException("O número de telefone do profissional não pode ser nulo ou vazio.");
        }
    }
}
