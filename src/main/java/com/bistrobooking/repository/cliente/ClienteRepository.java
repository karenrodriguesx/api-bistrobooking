package com.bistrobooking.repository.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("""
           SELECT NEW com.bistrobooking.dto.cliente.ClienteDTO (
                c.id,
                c.nome,
                c.email,
                c.telefone
           ) FROM Cliente as c
           WHERE c.excluido IS NULL
           AND c.id = :id
    """)
    Optional<ClienteDTO> buscarPorId(Long id);

    @Query("""
           SELECT NEW com.bistrobooking.dto.cliente.ClienteDTO (
                c.id,
                c.nome,
                c.email,
                c.telefone
           ) FROM Cliente as c
           WHERE c.excluido IS NULL
    """)
    Page<ClienteDTO> listar(Pageable pageable);

    @Query("""
           SELECT NEW com.bistrobooking.dto.cliente.ClienteDTO (
                c.id,
                c.nome,
                c.email,
                c.telefone
           ) FROM Cliente as c
           LEFT JOIN Reserva r ON c.id = r.cliente.id AND r.excluido IS NULL
           WHERE c.excluido IS NULL
           AND r.id = :idReserva
    """)
    Optional<ClienteDTO> buscarPorIdReserva(Long idReserva);
}
