package com.bistrobooking.service.impl.restaurante;

import com.bistrobooking.dto.restaurante.RestauranteSaveDTO;
import com.bistrobooking.service.restaurante.RestauranteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RestauranteServiceImpl implements RestauranteService {
    @Override
    public RestauranteSaveDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public Page<RestauranteSaveDTO> listar(Pageable pageable) {
        return null;
    }

    @Override
    public RestauranteSaveDTO salvar(RestauranteSaveDTO form) {
        return null;
    }

    @Override
    public RestauranteSaveDTO atualizar(Long id, RestauranteSaveDTO form) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
