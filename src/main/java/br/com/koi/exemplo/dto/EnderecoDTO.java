package br.com.koi.exemplo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EnderecoDTO
{

    @NotBlank
    @Size(max=100)
    private  String rua;


    @NotBlank
    @Size(max=10)
    private String numero;


    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(max=10)
    private String cep;

    @NotBlank
    @Size(max=2)
    private String uf;

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
