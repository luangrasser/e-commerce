package br.com.ll.ecommerce.dao.impl;

import br.com.ll.ecommerce.dao.FornecedorCustomRepository;
import br.com.ll.ecommerce.dao.filter.FornecedorFilter;
import br.com.ll.ecommerce.model.Fornecedor;
import br.com.ll.ecommerce.model.QFornecedor;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FornecedorCustomRepositoryImpl implements FornecedorCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Fornecedor> pesquisar(FornecedorFilter filter) {
        QFornecedor fornecedor = QFornecedor.fornecedor;
        BooleanBuilder builder = new BooleanBuilder();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        if (StringUtils.isNotBlank(filter.getNome())) {
            builder.and(fornecedor.nome.contains(filter.getNome()));
        }
        if (StringUtils.isNotBlank(filter.getEmail())) {
            builder.and(fornecedor.email.contains(filter.getEmail()));
        }
        if (StringUtils.isNotBlank(filter.getCpf())) {
            builder.and(fornecedor.cpf.contains(filter.getCpf()));
        }
        if (StringUtils.isNotBlank(filter.getGenero())) {
            builder.and(fornecedor.genero.contains(filter.getGenero()));
        }
        if (filter.getDataNascimento() != null) {
            builder.and(fornecedor.dataNascimento.eq(filter.getDataNascimento()));
        }
        if (filter.getTelefone() != null) {
            builder.and(fornecedor.telefone.eq(filter.getTelefone()));
        }
        if (filter.getAtivo() != null) {
            builder.and(fornecedor.ativo.eq(filter.getAtivo()));
        }
        return null;
    }
}
