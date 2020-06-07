package br.com.ll.ecommerce.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sigla;
    private String descricao;
    @ManyToOne
    private Pais pais;

}
