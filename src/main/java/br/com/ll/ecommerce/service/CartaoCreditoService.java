package br.com.ll.ecommerce.service;

import br.com.ll.ecommerce.dao.CartaoCreditoRepository;
import br.com.ll.ecommerce.dao.FornecedorRepository;
import br.com.ll.ecommerce.dao.filter.EnderecoFilter;
import br.com.ll.ecommerce.model.BandeiraCartao;
import br.com.ll.ecommerce.model.CartaoCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository repository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public CartaoCredito salvar(CartaoCredito cartaoCredito)  {
        cartaoCredito.setBandeiraCartao(BandeiraCartao.valueOf(cartaoCredito.getBandeira()));
        cartaoCredito.setFornecedor(fornecedorRepository.findById(cartaoCredito.getIdFornecedor()).orElse(null));
        return repository.save(cartaoCredito);
    }


    public List<CartaoCredito> pesquisarPorFornecedor(Integer id) {
        return repository.pesquisarPorFornecedor(id);
    }

    public void apagar(Integer id) throws Exception {
        CartaoCredito cartao = repository.findById(id)
                .orElseThrow(() -> new Exception("Cartão de crédito desconhecido."));
        repository.delete(cartao);
    }
}
