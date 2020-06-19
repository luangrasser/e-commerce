package br.com.ll.ecommerce.dao.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FornecedorFilter {

    private String nome;
    private String email;
    private String cpf;
    private String genero;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataNascimento;
    private Integer telefone;
    private Boolean ativo;
}
