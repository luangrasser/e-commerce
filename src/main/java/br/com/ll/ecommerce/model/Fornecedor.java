package br.com.ll.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends Pessoa {

    private static final long serialVersionUID = 1L;

    private String cpf;
    private String genero;
    private LocalDate dataNascimento;
    private Integer telefone;
    private boolean ativo;
    @ManyToOne
    private Produto produtoPadrao;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaoCredito> cartoesCredito;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;
}
