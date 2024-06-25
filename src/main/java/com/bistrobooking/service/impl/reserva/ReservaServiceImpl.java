package com.bistrobooking.service.impl.reserva;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.dto.reserva.ReservaFetchDTO;
import com.bistrobooking.dto.reserva.ReservaListDTO;
import com.bistrobooking.dto.reserva.ReservaSmallDTO;
import com.bistrobooking.dto.restaurante.RestauranteDTO;
import com.bistrobooking.entity.Cliente;
import com.bistrobooking.entity.Reserva;
import com.bistrobooking.entity.Restaurante;
import com.bistrobooking.repository.cliente.ClienteRepository;
import com.bistrobooking.repository.reserva.ReservaRepository;
import com.bistrobooking.repository.restaurante.RestauranteRepository;
import com.bistrobooking.service.base.reserva.ReservaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository repository;
    private final RestauranteRepository restauranteRepository;
    private final ClienteRepository clienteRepository;

    public ReservaServiceImpl(ReservaRepository repository, RestauranteRepository restauranteRepository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.restauranteRepository = restauranteRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ReservaFetchDTO buscarPorId(Long id) {
        ReservaFetchDTO reservaFetch = new ReservaFetchDTO();
        ReservaSmallDTO reserva = repository.buscarPorId(id).orElseThrow(
                () -> new IllegalArgumentException("Reserva não encontrada!"));
        reservaFetch.setReserva(reserva);

        RestauranteDTO restaurante = restauranteRepository.buscarPorIdReserva(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));
        reservaFetch.setRestaurante(restaurante);

        ClienteDTO cliente = clienteRepository.buscarPorIdReserva(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
        reservaFetch.setCliente(cliente);

        return reservaFetch;
    }

    @Override
    public Page<ReservaListDTO> listar(Pageable pageable) {
        return repository.listar(pageable);
    }

    @Override
    public ReservaDTO salvar(ReservaDTO form) {
        Reserva reserva = new Reserva();
        reserva.setDataHoraReserva(form.getDataHoraReserva());
        reserva.setQuantidadePessoas(form.getQuantidadePessoas());

        Restaurante restaurante = restauranteRepository.findById(form.getIdRestaurante())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));
        reserva.setRestaurante(restaurante);

        String emailPadronizado = form.getEmailCliente().toLowerCase();
        Cliente cliente = clienteRepository.findByEmail(emailPadronizado)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
        reserva.setCliente(cliente);

        repository.save(reserva);

        return form;
    }

    @Override
    public ReservaDTO atualizar(Long id, ReservaDTO form) {
        Reserva reserva = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Reserva não encontrada!"));

        if (reserva.getExcluido() == null) {
            reserva.setId(form.getId());
            reserva.setDataHoraReserva(form.getDataHoraReserva());
            reserva.setQuantidadePessoas(form.getQuantidadePessoas());

            repository.save(reserva);
        } else {
            throw new IllegalArgumentException("Reserva não encontrada!");
        }

        return form;
    }

    @Override
    public void excluir(Long id) {
        Reserva reserva = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Reserva não encontrada!"));

        if (reserva.getExcluido() == null) {
            reserva.setExcluido(LocalDateTime.now());
            repository.save(reserva);
        } else {
            throw new IllegalArgumentException("Reserva não encontrada!");
        }
    }
}
