package br.com.faxinafacil.controllers;

import br.com.faxinafacil.models.servicodefaxina.ServicoDeFaxina;
import br.com.faxinafacil.models.servicodefaxina.ServicoDeFaxinaRequest;
import br.com.faxinafacil.models.servicodefaxina.ServicoDeFaxinaResponse;
import br.com.faxinafacil.services.ServicoDeFaxinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoDeFaxinaController {

    private final ServicoDeFaxinaService servicoDeFaxinaService;

    public ServicoDeFaxinaController(ServicoDeFaxinaService servicoDeFaxinaService) {
        this.servicoDeFaxinaService = servicoDeFaxinaService;
    }

    @PostMapping
    public ResponseEntity<ServicoDeFaxinaResponse> criarServico(@RequestBody ServicoDeFaxinaRequest servico) {
        ServicoDeFaxina novoServico = servicoDeFaxinaService.salvarServico(servico.toServicoDeFaxina());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ServicoDeFaxinaResponse(novoServico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDeFaxina> obterServicoPorId(@PathVariable Long id) {
        ServicoDeFaxina servico = servicoDeFaxinaService.buscarPorId(id);
        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        servicoDeFaxinaService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ServicoDeFaxina>> listarServicos() {
         List<ServicoDeFaxina> servicos = servicoDeFaxinaService.listarTodos();
        return ResponseEntity.ok(servicoDeFaxinaService.listarTodos());
    }
}
