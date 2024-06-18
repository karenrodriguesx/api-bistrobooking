package com.bistrobooking.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface para serviços básicos de CRUD.
 *
 * @param <T> Tipo do DTO
 */

public interface BaseService <T>{
    /**
     * Busca um objeto pelo id.
     *
     * @param id O id do objeto a ser buscado
     * @return O objeto correspondente ao id fornecido
     */
    T buscarPorId(Long id);

    /**
     * Lista todos os objetos com paginação.
     *
     * @param pageable Informações de paginação
     * @return Uma lista paginada com as informações buscadas.
     */
    Page<T> listar(Pageable pageable);

    /**
     * Salva um novo objeto.
     *
     * @param form O DTO do objeto a ser salvo
     * @return O DTO do objeto salvo
     */
    T salvar(T form);

    /**
     * Atualiza um objeto existente.
     *
     * @param id O id do objeto a ser salvo
     * @param form O DTO do objeto a ser atualizado
     * @return O DTO do objeto atualizado
     */
    T atualizar(Long id, T form);

    /**
     * Exclui um objeto pelo id.
     *
     * @param id O id do objeto a ser excluido
     */
    void excluir(Long id);
}
