package com.bistrobooking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <T>{
    T buscarPorId(Long id);

    Page<T> listar(Pageable pageable);

    T salvar(T form);

    T atualizar(Long id, T form);

    void excluir(Long id);
}
