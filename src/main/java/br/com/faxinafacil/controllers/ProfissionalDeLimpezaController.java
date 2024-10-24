package br.com.faxinafacil.controllers;

import br.com.faxinafacil.exceptions.ProfissionalInvalidoException;
import br.com.faxinafacil.models.profissionaldelimpeza.ProfissionalDeLimpeza;
import br.com.faxinafacil.services.ProfissionalDeLimpezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalDeLimpezaController {

    private final ProfissionalDeLimpezaService profissionalDeLimpezaService;

    @Autowired
    public ProfissionalDeLimpezaController(ProfissionalDeLimpezaService profissionalDeLimpezaService) {
        this.profissionalDeLimpezaService = profissionalDeLimpezaService;
    }

    @PostMapping
    public ResponseEntity<ProfissionalDeLimpeza> enviarProfissional(@RequestBody ProfissionalDeLimpeza profissional) {
        ProfissionalDeLimpeza createdProfissional = profissionalDeLimpezaService.enviarProfissional(profissional);
        return new ResponseEntity<>(createdProfissional, HttpStatus.CREATED);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ProfissionalDeLimpeza> buscarPorCpf(@PathVariable String cpf) {
        try {
            ProfissionalDeLimpeza profissional = profissionalDeLimpezaService.buscarPorCpf(cpf);
            return new ResponseEntity<>(profissional, HttpStatus.OK);
        } catch (ProfissionalInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable String cpf) {
        try {
            profissionalDeLimpezaService.deletarProfissional(cpf);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProfissionalInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/existe/{cpf}")
    public ResponseEntity<Boolean> existeProfissional(@PathVariable String cpf) {
        boolean exists = profissionalDeLimpezaService.existeProfissional(cpf);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
