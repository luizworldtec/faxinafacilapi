package br.com.faxinafacil.controllers;

import br.com.faxinafacil.exceptions.PagamentoInvalidoException;
import br.com.faxinafacil.models.Pagamento;
import br.com.faxinafacil.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<Pagamento> enviarPagamento(@RequestBody Pagamento pagamento) {
        Pagamento createdPagamento = pagamentoService.enviarPagamento(pagamento);
        return new ResponseEntity<>(createdPagamento, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        try {
            Pagamento pagamento = pagamentoService.buscarPorId(id);
            return new ResponseEntity<>(pagamento, HttpStatus.OK);
        } catch (PagamentoInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        try {
            pagamentoService.deletarPagamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (PagamentoInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existePagamento(@PathVariable Long id) {
        boolean exists = pagamentoService.existePagamento(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}