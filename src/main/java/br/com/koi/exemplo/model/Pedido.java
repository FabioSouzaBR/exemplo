package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "pedidos")
public class Pedido implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @Column (name = "data", length = 12, nullable = false)
    private Date data;

    @Column(name="prazo",  length =  12, nullable = false)
    private Date prazo;

    @Column (name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "status", length = 1)
    private String status;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
