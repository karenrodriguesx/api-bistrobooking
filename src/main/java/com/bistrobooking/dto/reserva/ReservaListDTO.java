package com.bistrobooking.dto.reserva;

import java.time.LocalDateTime;

public class ReservaListDTO {
    private Long id;

    private Integer quantidadePessoas;

    private LocalDateTime dataReserva;

    private String nomeCliente;

    private String emailCliente;

    private String telefoneCliente;

    private String nomeRestaurante;

    private String telefoneRestaurante;

    public ReservaListDTO() {
    }

    public ReservaListDTO(Long id, Integer quantidadePessoas, LocalDateTime dataReserva, String nomeCliente, String emailCliente, String telefoneCliente, String nomeRestaurante, String telefoneRestaurante) {
        this.id = id;
        this.quantidadePessoas = quantidadePessoas;
        this.dataReserva = dataReserva;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.nomeRestaurante = nomeRestaurante;
        this.telefoneRestaurante = telefoneRestaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getTelefoneRestaurante() {
        return telefoneRestaurante;
    }

    public void setTelefoneRestaurante(String telefoneRestaurante) {
        this.telefoneRestaurante = telefoneRestaurante;
    }
}
