package br.com.ll.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class Pessoa extends EntidadeDominio {

    private String nome;
    private String email;
    private String senha;
}
