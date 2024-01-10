package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="impostos")
public class Imposto implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name = "descricao", length =  200, nullable = false)
    private String descricao;

    @Column(name = "recolhimento",length =  20,nullable = false)
    private String recolhimento;

    @Column (name = "aliquota", length =  4, nullable = false)
    private float aliquota;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRecolhimento() {
        return recolhimento;
    }

    public void setRecolhimento(String recolhimento) {
        this.recolhimento = recolhimento;
    }

    public float getAliquota() {
        return aliquota;
    }

    public void setAliquota(float aliquota) {
        this.aliquota = aliquota;
    }
}
