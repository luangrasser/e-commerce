package br.com.ll.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class Pessoa extends EntidadeDominio {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;
    @NotBlank(message = "O e-mail não pode estar em branco.")
    private String email;
    @JsonIgnore
    private String senha;
    @NotBlank(message = "A senha não pode estar em branco.")
    private String novaSenha;
}
