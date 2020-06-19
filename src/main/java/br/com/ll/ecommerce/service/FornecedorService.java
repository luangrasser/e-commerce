package br.com.ll.ecommerce.service;

import br.com.ll.ecommerce.dao.FornecedorRepository;
import br.com.ll.ecommerce.dao.filter.FornecedorFilter;
import br.com.ll.ecommerce.model.Fornecedor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor salvar(Fornecedor fornecedor) {
        if (StringUtils.isNotBlank(fornecedor.getNovaSenha())) {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            fornecedor.setSenha(encoder.encode(fornecedor.getNovaSenha()));
        }
        return repository.save(fornecedor);
    }

    public List<Fornecedor> pesquisar(FornecedorFilter filter) {
        return repository.pesquisar(filter);
    }

    /**
     * Ativa / inativa fornecedor
     * @param id
     * @throws Exception
     */
    public void atualizarStatus(Integer id) throws Exception {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> new Exception("Fornecedor desconhecido."));
        fornecedor.setAtivo(!fornecedor.isAtivo());
    }
}
