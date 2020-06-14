package br.com.ll.ecommerce.controller;


import br.com.ll.ecommerce.dao.EstadoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping("/pesquisar")
    public ResponseEntity<?> pesquisar(@RequestParam("pais") Integer codigo) {
        try {
            return ResponseEntity.ok(repository.pesquisarPorPais(codigo));
        } catch (Exception e) {
            log.error("Falha ao pesquisar estados.", e);
            return ResponseEntity.badRequest().body("Falha ao pesquisar estados.");
        }
    }
}
