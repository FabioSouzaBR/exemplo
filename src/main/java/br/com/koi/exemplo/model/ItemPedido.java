package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity (name="itempedido")
public class ItemPedido implements Serializable

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numped;

    @Column(name="codprod", length = 5, nullable = false)
    private Integer codprod;

    @Column(name="quantidade", length = 5, nullable = false)
    private Integer quantidade;

    @Column(name="valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name="desconto", precision = 10, scale = 2)
    private BigDecimal desconto;

    public Integer getNumped() {
        return numped;
    }

    public void setNumped(Integer numped) {
        this.numped = numped;
    }

    public Integer getCodprod() {
        return codprod;
    }

    public void setCodprod(Integer codprod) {
        this.codprod = codprod;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
