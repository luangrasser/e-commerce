package br.com.ll.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Produto extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    private String descricao;
    private String categoria;
    @ManyToOne
    private Fornecedor fornecedor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;
}
