package br.com.ll.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeDominio implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime dataCadastro;

}
