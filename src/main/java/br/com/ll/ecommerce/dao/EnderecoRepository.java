package br.com.ll.ecommerce.dao;

import br.com.ll.ecommerce.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "SELECT * FROM endereco WHERE fornecedor_id = ?1 AND tipoEndereco LIKE ?2", nativeQuery = true)
    List<Endereco> pesquisarPorFornecedor(Integer idFornecedor, String tipo);

    @Query(value = "SELECT * FROM endereco WHERE produto_id = ?1 AND tipoEndereco LIKE ?2", nativeQuery = true)
    List<Endereco> pesquisarPorProduto(Integer idProduto, String tipo);
}
