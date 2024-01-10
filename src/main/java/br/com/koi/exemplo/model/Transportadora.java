package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity ( name = "transportadoras")
public class Transportadora implements Serializable
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer codtransp;

    @Column (name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;

    @Column(name = "capacidade", length = 6)
    private int capacidade;

    public Integer getCodtransp() {
        return codtransp;
    }

    public void setCodtransp(Integer codtransp) {
        this.codtransp = codtransp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
