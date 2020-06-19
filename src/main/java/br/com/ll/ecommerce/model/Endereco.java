package br.com.ll.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Endereco extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    private String tipoDomicilio;
    @NotNull @NotEmpty
    private String logradouro;
    @NotNull @NotEmpty
    private String cep;
    @NotNull @NotEmpty
    private String numero;
    @NotNull @NotEmpty
    private String bairro;
    @NotNull @NotEmpty
    private String observacoes;
    @Transient
    @NotNull @NotEmpty
    private Integer idCidade;
    @Transient
    @NotNull @NotEmpty
    private String tipo;
    @Transient
    private Integer idProduto;
    @Transient
    private Integer idFornecedor;
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
    @ManyToOne
    @JsonIgnore
    private Produto produto;
    @ManyToOne
    @JsonIgnore
    private Fornecedor fornecedor;
    @ManyToOne
    @JsonIgnore
    private Cidade cidade;

}
