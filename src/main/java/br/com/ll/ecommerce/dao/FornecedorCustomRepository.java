package br.com.ll.ecommerce.dao;

import br.com.ll.ecommerce.dao.filter.FornecedorFilter;
import br.com.ll.ecommerce.model.Fornecedor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorCustomRepository {

    List<Fornecedor> pesquisar(FornecedorFilter filter);
}
