package br.com.ll.ecommerce.dao;

import br.com.ll.ecommerce.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>, FornecedorCustomRepository {
}
