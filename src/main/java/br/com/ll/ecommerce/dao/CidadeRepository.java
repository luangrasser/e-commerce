package br.com.ll.ecommerce.dao;

import br.com.ll.ecommerce.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query(value = "SELECT  * FROM cidade WHERE estado = ?1", nativeQuery = true)
    List<Cidade> pesquisarPorEstado(String uf);
}
