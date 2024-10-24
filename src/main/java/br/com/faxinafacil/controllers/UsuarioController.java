package br.com.faxinafacil.controllers;

import br.com.faxinafacil.models.usuario.Usuario;
import br.com.faxinafacil.models.usuario.UsuarioRequest;
import br.com.faxinafacil.models.usuario.UsuarioResponse;
import br.com.faxinafacil.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String cpf) {
        Usuario usuario = usuarioService.buscarUsuario(cpf);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario.toUsuario());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponse(novoUsuario));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable String cpf, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(cpf, usuario);
        if (usuarioAtualizado != null) {
            return ResponseEntity.ok(usuarioAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String cpf) {
        if (usuarioService.deletarUsuario(cpf)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
