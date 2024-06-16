package com.bistrobooking.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService <T>{
    Optional<T> buscarPorId(Long id);

    Page<T> listar(Pageable pageable);

    T salvar(T form);

    T atualizar(Long id, T form);

    void excluir(Long id);
}
