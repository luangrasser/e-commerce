package br.com.ll.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Produto extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    private String descricao;
    private String categoria;
    @Transient
    private Integer idFornecedor;
    @ManyToOne
    @JsonIgnore
    private Fornecedor fornecedor;
    private Boolean padraoFornecedor = false;
}
