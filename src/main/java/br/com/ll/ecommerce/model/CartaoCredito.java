package br.com.ll.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class CartaoCredito extends EntidadeDominio {

    private static final long serialVersionUID = 1L;

    private String numeroCartao;
    private LocalDate validade;
    private String nomeImpresso;
    private Integer codigoSeguranca;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;
    @ManyToOne
    private Fornecedor fornecedor;
}
