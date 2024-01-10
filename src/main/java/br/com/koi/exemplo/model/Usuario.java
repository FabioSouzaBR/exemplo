package br.com.koi.exemplo.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity(name="usuarios")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "login", length = 15, nullable = false)
    private String login;

    @Column(name = "senha", length = 8, nullable = false)
    private String senha;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
