package br.com.koi.exemplo.dto;


import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ProdutoDTO
{
    @NotBlank
    private String descricao;

    private Integer estoque;


    private BigDecimal valor;

    private Integer lote;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }
}
