package com.bistrobooking.dto.restaurante;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class RestauranteDTO {
    private Long id;

    @NotBlank (message = "O campo nome do restaurante é obrigatório")
    private String nome;

    @Schema(type = "string", example = "Servimos o melhor hambúrguer")
    private String descricao;

    @Valid
    private EnderecoDTO endereco;

    @NotBlank (message = "O campo telefone é obrigatório")
    private String telefone;

    @Schema(type = "string", example = "Variado")
    private String tipoCulinaria;

    public RestauranteDTO() {
    }

    public RestauranteDTO(Long id, String nome, String descricao, EnderecoDTO endereco, String telefone, String tipoCulinaria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoCulinaria = tipoCulinaria;
    }

    public RestauranteDTO(Long id, String nome, String descricao, String telefone, String tipoCulinaria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipoCulinaria = tipoCulinaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoCulinaria() {
        return tipoCulinaria;
    }

    public void setTipoCulinaria(String tipoCulinaria) {
        this.tipoCulinaria = tipoCulinaria;
    }
}
