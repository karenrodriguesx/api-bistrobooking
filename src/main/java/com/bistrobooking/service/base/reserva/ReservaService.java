package com.bistrobooking.service.base.reserva;

import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.dto.reserva.ReservaFetchDTO;
import com.bistrobooking.dto.reserva.ReservaListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReservaService {
    Optional<ReservaFetchDTO> buscarPorId(Long id);

    Page<ReservaListDTO> listar(Pageable pageable);

    ReservaDTO salvar(ReservaDTO form);

    ReservaDTO atualizar(Long id, ReservaDTO form);

    void excluir(Long id);
}
