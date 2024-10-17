package br.com.faxinafacil.controllers;

import br.com.faxinafacil.exceptions.AvaliacaoInvalidaException;
import br.com.faxinafacil.models.Avaliacao;
import br.com.faxinafacil.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public ResponseEntity<Avaliacao> enviarAvaliacao(@RequestBody Avaliacao avaliacao) {
        Avaliacao createdAvaliacao = avaliacaoService.enviarAvaliacao(avaliacao);
        return new ResponseEntity<>(createdAvaliacao, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        try {
            Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
            return new ResponseEntity<>(avaliacao, HttpStatus.OK);
        } catch (AvaliacaoInvalidaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable Long id) {
        try {
            avaliacaoService.deletarAvaliacao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AvaliacaoInvalidaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existeAvaliacao(@PathVariable Long id) {
        boolean exists = avaliacaoService.existeAvaliacao(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
