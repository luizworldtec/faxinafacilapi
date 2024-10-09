package br.com.faxinafacil.services;

import br.com.faxinafacil.exceptions.UsuarioInvalidoException;
import br.com.faxinafacil.models.Usuario;
import br.com.faxinafacil.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        validarUsuario(usuario);
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorCpf(String cpf) {
        return usuarioRepository.findById(cpf).orElseThrow(() ->
                new UsuarioInvalidoException("Usuário não encontrado com o CPF: " + cpf));
    }

    public void deletarUsuario(String cpf) {
        if (!usuarioRepository.existsById(cpf)) {
            throw new UsuarioInvalidoException("Usuário não encontrado com o CPF: " + cpf);
        }
        usuarioRepository.deleteById(cpf);
    }

    public boolean existeUsuario(String cpf) {
        return usuarioRepository.existsById(cpf);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            throw new UsuarioInvalidoException("O CPF do usuário não pode ser nulo ou vazio.");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new UsuarioInvalidoException("O nome do usuário não pode ser nulo ou vazio.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new UsuarioInvalidoException("O email do usuário não pode ser nulo ou vazio.");
        }
        if (usuario.getNumTel() == null || usuario.getNumTel().isEmpty()) {
            throw new UsuarioInvalidoException("O número de telefone do usuário não pode ser nulo ou vazio.");
        }
        // Adicione mais validações conforme necessário
    }
}
