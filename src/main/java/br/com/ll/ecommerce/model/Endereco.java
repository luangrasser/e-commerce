package br.com.ll.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Endereco extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    private String tipoDomicilio;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String observacoes;
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private Cidade cidade;
}
