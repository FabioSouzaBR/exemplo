package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity (name="notasfiscais")
public class NotaFiscal implements Serializable

{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer Numero;

    @Column (name = "emissao", length = 12, nullable = false)
    private Date emissao;

    @Column(name="prazo",  length =  12, nullable = false)
    private Date prazo;

    @Column (name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
