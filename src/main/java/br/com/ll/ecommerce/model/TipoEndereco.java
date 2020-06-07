package br.com.ll.ecommerce.model;

import lombok.Getter;

@Getter
public enum TipoEndereco {

    ENTREGA("Entrega"),
    COBRANCA("Cobrança");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
}
