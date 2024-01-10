package br.com.koi.exemplo.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity (name="produtos")
public class Produto implements Serializable
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer codprod;

    @Column (name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column (name = "estoque", length = 3, nullable = false)
    private Integer estoque;

    @Column (name = "lote", length = 3)
    private Integer lote;

    @Column (name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    public Integer getCodprod() {
        return codprod;
    }

    public void setCodprod(Integer codprod) {
        this.codprod = codprod;
    }

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

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
