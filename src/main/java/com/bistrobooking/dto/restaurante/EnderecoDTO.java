package com.bistrobooking.dto.restaurante;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class EnderecoDTO {
    private Long id;

    @Schema(type = "string", example = "77777777")
    @NotBlank(message = "O campo CEP é obrigatório")
    private String cep;

    @Schema(type = "string", example = "Rua ABC")
    @NotBlank (message = "O campo logradouro é obrigatório")
    private String logradouro;

    @Schema(type = "string", example = "Ao lado do shopping ABC")
    private String complemento;

    @Schema(type = "string", example = "Centro")
    @NotBlank (message = "O campo bairro é obrigatório")
    private String bairro;

    @Schema(type = "string", example = "São Paulo")
    private String localidade;

    @Schema(type = "string", example = "SP")
    @NotBlank (message = "O campo UF é obrigatório")
    private String uf;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
