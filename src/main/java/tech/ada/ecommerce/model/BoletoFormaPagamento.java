package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoletoFormaPagamento extends FormaPagamento{
    @Column(unique = true, nullable = true)
    private String codigoBoleto;
    public BoletoFormaPagamento(){super();}
}
