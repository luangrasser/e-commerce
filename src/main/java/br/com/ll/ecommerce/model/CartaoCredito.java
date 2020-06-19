package br.com.ll.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class CartaoCredito extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    @NotNull @NotEmpty
    private String numeroCartao;
    @NotNull @NotEmpty
    private LocalDate validade;
    @NotNull @NotEmpty
    private String nomeImpresso;
    @NotNull @NotEmpty
    private Integer codigoSeguranca;
    @Transient
    @NotNull @NotEmpty
    private String bandeira;
    @Transient
    @NotNull @NotEmpty
    private Integer idFornecedor;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;
    @ManyToOne
    @JsonIgnore
    private Fornecedor fornecedor;
}
