package br.com.ll.ecommerce.controller;

import br.com.ll.ecommerce.dao.filter.EnderecoFilter;
import br.com.ll.ecommerce.model.Endereco;
import br.com.ll.ecommerce.service.EnderecoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid Endereco endereco) {
        try {
            return ResponseEntity.ok(service.salvar(endereco));
        } catch (Exception e) {
            log.error("Falha ao salvar endereço.", e);
            return ResponseEntity.badRequest().body("Falha ao salvar endereço.");
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<?> pesquisar(@RequestBody EnderecoFilter filter) {
        try {
            return ResponseEntity.ok(service.pesquisar(filter));
        } catch (Exception e) {
            log.error("Falha ao pesquisar endereços.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/apagar")
    public ResponseEntity<?> apagar(@RequestParam(value = "id") Integer id) {
        try {
            service.apagar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Falha ao apagar morador.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
