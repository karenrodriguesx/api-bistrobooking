package com.bistrobooking.service.impl.restaurante;

import com.bistrobooking.dto.restaurante.EnderecoDTO;
import com.bistrobooking.dto.restaurante.RestauranteDTO;
import com.bistrobooking.entity.Endereco;
import com.bistrobooking.entity.Restaurante;
import com.bistrobooking.repository.restaurante.EnderecoRepository;
import com.bistrobooking.repository.restaurante.RestauranteRepository;
import com.bistrobooking.service.base.restaurante.RestauranteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository repository;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoServiceImpl enderecoServiceImpl;

    public RestauranteServiceImpl(RestauranteRepository repository, EnderecoRepository enderecoRepository, EnderecoServiceImpl enderecoServiceImpl) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
        this.enderecoServiceImpl = enderecoServiceImpl;
    }

    @Override
    public RestauranteDTO buscarPorId(Long id) {
        RestauranteDTO restaurante = repository.buscarPorId(id).orElseThrow(
                () -> new IllegalArgumentException("Restaurante não encontrado!"));

        EnderecoDTO endereco = enderecoRepository.buscarPorIdRestaurante(id).orElseThrow(
                () -> new IllegalArgumentException("Endereço não encontrado!"));

        restaurante.setEndereco(endereco);

        return restaurante;
    }

    @Override
    public Page<RestauranteDTO> listar(Pageable pageable) {
        Page<RestauranteDTO> restaurante = repository.listar(pageable);

        restaurante.forEach(r -> {
            EnderecoDTO endereco = enderecoRepository.buscarPorIdRestaurante(r.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado!"));
            r.setEndereco(endereco);
        });

        return restaurante;
    }

    @Override
    public RestauranteDTO salvar(RestauranteDTO form) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(form.getNome().toUpperCase());
        restaurante.setDescricao(form.getDescricao());
        restaurante.setTelefone(form.getTelefone());
        restaurante.setTipoCulinaria(form.getTipoCulinaria());

        EnderecoDTO enderecoDTO = enderecoServiceImpl.salvar(form.getEndereco());
        Endereco endereco = enderecoRepository.findById(enderecoDTO.getId()).orElse(null);
        restaurante.setEndereco(endereco);

        repository.save(restaurante);

        return form;
    }

    @Override
    public RestauranteDTO atualizar(Long id, RestauranteDTO form) {
        Restaurante restaurante = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Restaurante não encontrado!"));

        if (restaurante.getExcluido() == null) {
            restaurante.setId(id);
            restaurante.setNome(form.getNome().toUpperCase());
            restaurante.setDescricao(form.getDescricao());
            restaurante.setTelefone(form.getTelefone());
            restaurante.setTipoCulinaria(form.getTipoCulinaria());

            Long enderecoId = form.getEndereco().getId();

            if (enderecoId != null) {
                Endereco endereco = enderecoRepository.findById(enderecoId)
                        .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
                restaurante.setEndereco(endereco);
            } else {
                enderecoServiceImpl.salvar(form.getEndereco());
            }

            repository.save(restaurante);
        } else {
            throw new IllegalArgumentException("Restaurante não encontrado!");
        }

        return form;
    }

    @Override
    public void excluir(Long id) {
        Restaurante restaurante = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Restaurante não encontrado!"));

        if (restaurante.getExcluido() == null) {
            restaurante.setExcluido(LocalDateTime.now());
            repository.save(restaurante);

            Long enderecoId = restaurante.getEndereco().getId();
            enderecoServiceImpl.excluir(enderecoId);
        } else {
            throw new IllegalArgumentException("Restaurante não encontrado!");
        }
    }
}
