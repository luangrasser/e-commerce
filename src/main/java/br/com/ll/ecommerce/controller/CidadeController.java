package br.com.ll.ecommerce.controller;

import br.com.ll.ecommerce.dao.CidadeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping("/pesquisar")
    public ResponseEntity<?> pesquisar(@RequestParam("uf") String uf) {
        try {
            return ResponseEntity.ok(repository.pesquisarPorEstado(uf));
        } catch (Exception e) {
            log.error("Falha ao pesquisar cidades.", e);
            return ResponseEntity.badRequest().body("Falha ao pesquisar cidades.");
        }
    }
}
