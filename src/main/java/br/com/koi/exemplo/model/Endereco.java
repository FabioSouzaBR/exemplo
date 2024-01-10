package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity (name = "enderecos")
public class Endereco implements Serializable

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codend;

    @Column(name = "rua", length = 100, nullable = false)
    private String rua;

    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "cep", length = 100, nullable = false)
    private String cep;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    public Integer getCodend() {
        return codend;
    }

    public void setCodend(Integer codend) {
        this.codend = codend;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
