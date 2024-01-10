package br.com.koi.exemplo.dto;

import jakarta.validation.constraints.NotBlank;

public class TransportadoraDTO
{
    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    private Integer capacidade;

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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
