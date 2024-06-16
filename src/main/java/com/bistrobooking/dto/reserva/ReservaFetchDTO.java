package com.bistrobooking.dto.reserva;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.dto.restaurante.RestauranteDTO;

public class ReservaFetchDTO {
    private Long id;

    private ReservaSmallDTO reserva;

    private ClienteDTO cliente;

    private RestauranteDTO restaurante;

    public ReservaFetchDTO() {
    }

    public ReservaFetchDTO(Long id, ReservaSmallDTO reserva, ClienteDTO cliente, RestauranteDTO restaurante) {
        this.id = id;
        this.reserva = reserva;
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public ReservaSmallDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaSmallDTO reserva) {
        this.reserva = reserva;
    }
}
