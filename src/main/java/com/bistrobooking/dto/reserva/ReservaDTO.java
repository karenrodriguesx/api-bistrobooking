package com.bistrobooking.dto.reserva;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Long id;

    @NotNull(message = "Para criar uma reserva, é obrigatório informar o código (id) do restaurante")
    private Long codigoRestaurante;

    @Schema(type = "string", example = "cliente@ahkc.com")
    @NotBlank(message = "Para criar uma reserva, é obrigatório informar o e-mail do cliente")
    private String emailCliente;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Schema(type = "string", pattern = "dd/MM/yyyy HH:mm:ss", example = "25/06/2024 18:00:00")
    private LocalDateTime dataHoraReserva;

    @Schema(type = "integer", example = "cliente@ahkc.com")
    private Integer quantidadePessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoRestaurante() {
        return codigoRestaurante;
    }

    public void setCodigoRestaurante(Long codigoRestaurante) {
        this.codigoRestaurante = codigoRestaurante;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
}
