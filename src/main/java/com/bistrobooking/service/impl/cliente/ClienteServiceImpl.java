package com.bistrobooking.service.impl.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.service.cliente.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClienteServiceImpl implements ClienteService {
    @Override
    public ClienteDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public Page<ClienteDTO> listar(Pageable pageable) {
        return null;
    }

    @Override
    public ClienteDTO salvar(ClienteDTO form) {
        return null;
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO form) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
