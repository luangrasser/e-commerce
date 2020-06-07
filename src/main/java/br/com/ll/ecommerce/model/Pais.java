package br.com.ll.ecommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer codigo;
    private String descricao;
}
