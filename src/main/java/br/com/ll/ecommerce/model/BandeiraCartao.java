package br.com.ll.ecommerce.model;

import lombok.Getter;

@Getter
public enum BandeiraCartao {

    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo"),
    AMERICAN_EXPRESS("American Express"),
    HIPERCARD("Hipercard"),
    HIPER("Hiper"),
    DINNERS_CLUB("Dinners Club"),
    CABAL("Cabal");

    private String descricao;

    BandeiraCartao(String descricao) {
        this.descricao = descricao;
    }

}
