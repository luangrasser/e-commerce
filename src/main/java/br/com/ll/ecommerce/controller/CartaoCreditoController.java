package br.com.ll.ecommerce.controller;

import br.com.ll.ecommerce.model.CartaoCredito;
import br.com.ll.ecommerce.service.CartaoCreditoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/cartaocredito")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService service;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid CartaoCredito cartaoCredito) {
        try {
            return ResponseEntity.ok(service.salvar(cartaoCredito));
        } catch (Exception e) {
            log.error("Falha ao salvar cartão de crédito.", e);
            return ResponseEntity.badRequest().body("Falha ao salvar cartão de crédito.");
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<?> pesquisar(@RequestParam("fornecedor") Integer id) {
        try {
            return ResponseEntity.ok(service.pesquisarPorFornecedor(id));
        } catch (Exception e) {
            log.error("Falha ao pesquisar cartões de crédito.", e);
            return ResponseEntity.badRequest().body("Falha ao pesquisar cartões de crédito.");
        }
    }

    @DeleteMapping("/apagar")
    public ResponseEntity<?> apagar(@RequestParam(value = "id") Integer id) {
        try {
            service.apagar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Falha ao apagar cartão de crédito.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}