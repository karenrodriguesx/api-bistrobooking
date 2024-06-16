package com.bistrobooking.dto.reserva;

import java.time.LocalDateTime;

public class ReservaSmallDTO {
    private Long id;

    private LocalDateTime dataHoraReserva;

    private Integer quantidadePessoas;

    public ReservaSmallDTO() {
    }

    public ReservaSmallDTO(Long id, LocalDateTime dataHoraReserva, Integer quantidadePessoas) {
        this.id = id;
        this.dataHoraReserva = dataHoraReserva;
        this.quantidadePessoas = quantidadePessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
