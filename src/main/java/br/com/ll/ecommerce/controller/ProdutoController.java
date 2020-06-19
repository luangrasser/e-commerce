package br.com.ll.ecommerce.controller;


import br.com.ll.ecommerce.model.Produto;
import br.com.ll.ecommerce.service.ProdutoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody @Valid Produto produto) {
        try {
            return ResponseEntity.ok(service.salvar(produto));
        } catch (Exception e) {
            log.error("Falha ao salvar produto.", e);
            return ResponseEntity.badRequest().body("Falha ao salvar produto.");
        }
    }


}
