package br.com.faxinafacil.repositories;

import br.com.faxinafacil.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
