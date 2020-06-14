package br.com.ll.ecommerce.dao;

import br.com.ll.ecommerce.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query(value = "SELECT * FROM estado WHERE pais_codigo = ?1", nativeQuery = true)
    List<Estado> pesquisarPorPais(Integer codigo);
}
