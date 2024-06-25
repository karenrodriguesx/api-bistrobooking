package com.bistrobooking.service.base.reserva;

import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.dto.reserva.ReservaFetchDTO;
import com.bistrobooking.dto.reserva.ReservaListDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface para serviços básicos de CRUD da classe Reserva, que precisa de DTOs diferentes para cada operação.
 *
 */
public interface ReservaService {

    /**
     * Busca um objeto pelo id.
     *
     * @param id O id do objeto a ser buscado
     * @return O objeto correspondente ao id fornecido
     */
    ReservaFetchDTO buscarPorId(Long id);

    /**
     * Lista todos os objetos com paginação.
     *
     * @param pageable Informações de paginação
     * @return Uma lista paginada com as informações buscadas.
     */
    Page<ReservaListDTO> listar(Pageable pageable);

    /**
     * Salva um novo objeto.
     *
     * @param form O DTO do objeto a ser salvo
     * @return O DTO do objeto salvo
     */
    @Transactional
    ReservaDTO salvar(ReservaDTO form);

    /**
     * Atualiza um objeto existente.
     *
     * @param id O id do objeto a ser salvo
     * @param form O DTO do objeto a ser atualizado
     * @return O DTO do objeto atualizado
     */
    @Transactional
    ReservaDTO atualizar(Long id, ReservaDTO form);

    /**
     * Exclui um objeto pelo id.
     *
     * @param id O id do objeto a ser excluido
     */
    void excluir(Long id);
}
