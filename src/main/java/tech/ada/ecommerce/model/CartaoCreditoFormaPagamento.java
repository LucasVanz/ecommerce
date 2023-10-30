package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class CartaoCreditoFormaPagamento extends FormaPagamento{
    @Column(unique = true, nullable = false, length = 16)
    private String numeroCartao;
    @Column(nullable = false)
    private String nomeTitular;
    @Column(nullable = false)
    private Date validade;
    @Column(nullable = false, length = 3)
    private String cvv;
    @Column(nullable = false)
    private int qtdParcelas;
    @Column(nullable = false)
    private String cpfTitular;

    public CartaoCreditoFormaPagamento(){super();}
}
