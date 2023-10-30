package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PixFormaPagamento extends FormaPagamento{
    @Column(unique = true, nullable = false)
    private String codigoPagamento;

    public PixFormaPagamento(){
        super();
    }
}
