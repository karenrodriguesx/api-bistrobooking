package com.bistrobooking.repository.restaurante;

import com.bistrobooking.dto.restaurante.EnderecoDTO;
import com.bistrobooking.entity.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.EnderecoDTO (
                e.id,
                e.cep,
                e.logradouro,
                e.complemento,
                e.bairro,
                e.localidade,
                e.uf
           ) FROM Endereco as e
           WHERE e.id = :id
    """)
    Optional<EnderecoDTO> buscarPorId(Long id);

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.EnderecoDTO (
                e.id,
                e.cep,
                e.logradouro,
                e.complemento,
                e.bairro,
                e.localidade,
                e.uf
           ) FROM Endereco as e
    """)
    Page<EnderecoDTO> listar(Pageable pageable);

    @Query("""
           SELECT NEW com.bistrobooking.dto.restaurante.EnderecoDTO (
                e.id,
                e.cep,
                e.logradouro,
                e.complemento,
                e.bairro,
                e.localidade,
                e.uf
           ) FROM Endereco as e
           LEFT JOIN Restaurante as r ON r.endereco.id = e.id
           WHERE r.id = :idRestaurante
    """)
    Optional<EnderecoDTO> buscarPorIdRestaurante(Long idRestaurante);
}
