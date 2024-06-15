package com.bistrobooking.service.impl.reserva;

import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.service.reserva.ReservaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ReservaServiceImpl implements ReservaService {
    @Override
    public ReservaDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public Page<ReservaDTO> listar(Pageable pageable) {
        return null;
    }

    @Override
    public ReservaDTO salvar(ReservaDTO form) {
        return null;
    }

    @Override
    public ReservaDTO atualizar(Long id, ReservaDTO form) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
