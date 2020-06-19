package br.com.ll.ecommerce.service;

import br.com.ll.ecommerce.dao.CidadeRepository;
import br.com.ll.ecommerce.dao.EnderecoRepository;
import br.com.ll.ecommerce.dao.FornecedorRepository;
import br.com.ll.ecommerce.dao.ProdutoRepository;
import br.com.ll.ecommerce.dao.filter.EnderecoFilter;
import br.com.ll.ecommerce.model.Endereco;
import br.com.ll.ecommerce.model.TipoEndereco;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Endereco salvar(Endereco endereco) {
        if (endereco.getIdFornecedor() != null) {
            endereco.setFornecedor(
                    fornecedorRepository.findById(endereco.getIdFornecedor()).orElse(null)
            );
        }
        if (endereco.getIdProduto() != null) {
            endereco.setProduto(
                    produtoRepository.findById(endereco.getIdProduto()).orElse(null)
            );
        }
        endereco.setCidade(
                cidadeRepository.findById(endereco.getIdCidade()).orElse(null)
        );
        endereco.setTipoEndereco(TipoEndereco.valueOf(endereco.getTipo()));
        return repository.save(endereco);
    }


    public List<Endereco> pesquisar(EnderecoFilter filter) throws Exception {
        List<Endereco> lista = new ArrayList<>();
        if (StringUtils.isBlank(filter.getTipo())) {
            throw new Exception("Informe o tipo de endereço.");
        }
        if (filter.getIdFornecedor() != null) {
            lista = repository.pesquisarPorFornecedor(filter.getIdFornecedor(), filter.getTipo());
        }
        if (filter.getIdProduto() != null) {
            lista = repository.pesquisarPorProduto(filter.getIdProduto(), filter.getTipo());
        }
        return lista;
    }

    public void apagar(Integer id) throws Exception {
        Endereco endereco = repository.findById(id).orElseThrow(() -> new Exception("Endereco desconhecido."));
        repository.delete(endereco);
    }
}
