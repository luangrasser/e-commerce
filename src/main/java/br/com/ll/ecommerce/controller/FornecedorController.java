package br.com.ll.ecommerce.controller;

import br.com.ll.ecommerce.dao.filter.FornecedorFilter;
import br.com.ll.ecommerce.model.Fornecedor;
import br.com.ll.ecommerce.service.FornecedorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Fornecedor fornecedor) {
        try {
            return ResponseEntity.ok(service.salvar(fornecedor));
        } catch (Exception e) {
            log.error("Falha ao salvar fornecedor.", e);
            return ResponseEntity.badRequest().body("Falha ao salvar fornecedor.");
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<?> pesquisar(FornecedorFilter filter) {
        try {
            return ResponseEntity.ok(service.pesquisar(filter));
        } catch (Exception e) {
            log.error("Falha ao pesquisar fornecedores.", e);
            return ResponseEntity.badRequest().body("Falha ao pesquisar fornecedores.");
        }
    }

    @DeleteMapping("/atualizarStatus")
    public ResponseEntity<?> atualizarStatus(@RequestParam(value = "id") Integer id) {
        try {
            service.atualizarStatus(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Falha ao apagar morador.", e);
            return ResponseEntity.badRequest().body("Falha ao apagar morador.");
        }
    }

}
