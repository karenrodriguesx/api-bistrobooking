package com.bistrobooking.repository.reserva;

import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.dto.reserva.ReservaListDTO;
import com.bistrobooking.dto.reserva.ReservaSmallDTO;
import com.bistrobooking.entity.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("""
           SELECT NEW com.bistrobooking.dto.reserva.ReservaSmallDTO (
                r.id,
                r.dataHoraReserva,
                r.quantidadePessoas
           ) FROM Reserva as r
           WHERE r.excluido IS NULL
           AND r.id = :id
    """)
    Optional<ReservaSmallDTO> buscarPorId(Long id);

    @Query("""
           SELECT NEW com.bistrobooking.dto.reserva.ReservaListDTO (
                r.id,
                r.quantidadePessoas,
                r.dataHoraReserva,
                cliente.nome,
                cliente.email,
                cliente.telefone,
                restaurante.nome,
                restaurante.telefone
           ) FROM Reserva as r
           LEFT JOIN r.cliente cliente
           LEFT JOIN r.restaurante restaurante
           WHERE r.excluido IS NULL
    """)
    Page<ReservaListDTO> listar(Pageable pageable);
}
