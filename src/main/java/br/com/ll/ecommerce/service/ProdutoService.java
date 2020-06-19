package br.com.ll.ecommerce.service;

import br.com.ll.ecommerce.dao.FornecedorRepository;
import br.com.ll.ecommerce.dao.ProdutoRepository;
import br.com.ll.ecommerce.dao.filter.ProdutoFilter;
import br.com.ll.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Produto salvar(Produto produto) {
        if (produto.getIdFornecedor() != null) {
            produto.setFornecedor(
                    fornecedorRepository.findById(produto.getIdFornecedor()).orElse(null)
            );
        }
        return repository.save(produto);
    }

}
