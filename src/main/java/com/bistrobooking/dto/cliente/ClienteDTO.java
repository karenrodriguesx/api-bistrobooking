package com.bistrobooking.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
    private Long id;

    @Schema(type = "string", example = "Cliente")
    @NotBlank(message = "O campo nome do cliente é obrigatório")
    private String nome;

    @Schema(type = "string", example = "cliente@ahkc.com")
    @NotBlank (message = "O campo e-mail do cliente é obrigatório")
    private String email;

    @Schema(type = "string", example = "99 99999-9999")
    private String telefone;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
