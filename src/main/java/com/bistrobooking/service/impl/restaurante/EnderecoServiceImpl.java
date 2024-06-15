package com.bistrobooking.service.impl.restaurante;

import com.bistrobooking.dto.restaurante.EnderecoDTO;
import com.bistrobooking.service.restaurante.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EnderecoServiceImpl implements EnderecoService {
    @Override
    public EnderecoDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public Page<EnderecoDTO> listar(Pageable pageable) {
        return null;
    }

    @Override
    public EnderecoDTO salvar(EnderecoDTO form) {
        return null;
    }

    @Override
    public EnderecoDTO atualizar(Long id, EnderecoDTO form) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
