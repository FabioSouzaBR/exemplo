package br.com.koi.exemplo.dto;

import jakarta.validation.constraints.NotBlank;

public class ImpostoDTO
{
    @NotBlank
    private String descricao;

    @NotBlank
    private String recolhimento;

    private float aliquota;

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
