package com.bistrobooking.repository.restaurante;

import com.bistrobooking.dto.restaurante.RestauranteDTO;
import com.bistrobooking.entity.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.RestauranteDTO (
                r.id,
                r.nome,
                r.descricao,
                r.telefone,
                r.tipoCulinaria
           ) FROM Restaurante as r
           WHERE r.excluido IS NULL
           AND r.id = :id
    """)
    Optional<RestauranteDTO> buscarPorId(Long id);

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.RestauranteDTO (
                r.id,
                r.nome,
                r.descricao,
                r.telefone,
                r.tipoCulinaria
           ) FROM Restaurante as r
           WHERE r.excluido IS NULL
    """)
    Page<RestauranteDTO> listar(Pageable pageable);

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.RestauranteDTO (
                r.id,
                r.nome,
                r.descricao,
                r.telefone,
                r.tipoCulinaria
           ) FROM Restaurante as r
           LEFT JOIN Reserva as reserva ON r.id = reserva.restaurante.id
           WHERE r.excluido IS NULL
           AND reserva.id = :idReserva
    """)
    Optional<RestauranteDTO> buscarPorIdReserva(Long idReserva);

    Optional<Restaurante> findByNome(String nome);
}
