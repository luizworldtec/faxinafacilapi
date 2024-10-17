package br.com.faxinafacil.services;

import br.com.faxinafacil.models.Usuario;
import br.com.faxinafacil.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(String cpf) {
        return usuarioRepository.findById(cpf).orElse(null);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(String cpf, Usuario usuario) {
        if (usuarioRepository.existsById(cpf)) {
            usuario.setCpf(cpf);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deletarUsuario(String cpf) {
        if (usuarioRepository.existsById(cpf)) {
            usuarioRepository.deleteById(cpf);
            return true;
        }
        return false;
    }
}
