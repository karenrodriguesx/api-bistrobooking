package com.bistrobooking.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_restaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Column(name = "dth_reserva")
    private LocalDateTime dataHoraReserva;

    @Column(name = "qtd_pessoas")
    private Integer quantidadePessoas;

    public Reserva() {
    }

    public Reserva(Long id, Restaurante restaurante, Cliente cliente, LocalDateTime dataHoraReserva, Integer quantidadePessoas) {
        this.id = id;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.dataHoraReserva = dataHoraReserva;
        this.quantidadePessoas = quantidadePessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
