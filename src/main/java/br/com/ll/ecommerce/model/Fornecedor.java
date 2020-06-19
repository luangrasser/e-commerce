package br.com.ll.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends Pessoa {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O CPF não pode estar em branco.")
    private String cpf;
    @NotBlank(message = "O gênero não pode estar em branco.")
    private String genero;
    @NotNull(message = "A data de nascimento não pode estar em branco.")
    private LocalDate dataNascimento;
    @NotNull(message = "O telefone não pode estar em branco.")
    private Integer telefone;
    private boolean ativo = true;

}
