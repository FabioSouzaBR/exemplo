package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity (name = "clientes")
public class Cliente implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codcli;

    @Column(name = "nome", length =  200, nullable = false)
    private String nome;

    @Column(name = "telefone", length =  15, nullable = false)
    private String telefone;

    @Column(name = "tipo", length =  1, nullable = false)
    private String tipo;

    @Column(name = "rg", length = 20)
    private String rg;

    @Column(name="cpf", length = 15)
    private String cpf;

    @Column(name="cnpj", length = 18)
    private String cnpj;

    @Column(name="ie",length = 20)
    private String ie;

    @Column(name="comprador",length = 100)
    private String comprador;

    @Column(name="razaosocial", length = 200)
    private String razaosocial ;

    public Integer getCodcli() {
        return codcli;
    }

    public void setCodcli(Integer codcli) {
        this.codcli = codcli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }
}
