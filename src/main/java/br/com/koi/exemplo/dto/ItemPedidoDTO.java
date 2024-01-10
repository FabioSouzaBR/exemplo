package br.com.koi.exemplo.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemPedidoDTO
{
    @NotNull
    private Integer codprod;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private BigDecimal desconto;

    public Integer getCodprod() {
        return codprod;
    }

    public void setCodprod(Integer codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
