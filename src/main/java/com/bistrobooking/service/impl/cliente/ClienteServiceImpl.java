package com.bistrobooking.service.impl.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.entity.Cliente;
import com.bistrobooking.repository.cliente.ClienteRepository;
import com.bistrobooking.service.base.cliente.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ClienteDTO> buscarPorId(Long id) {
        return Optional.of(repository.buscarPorId(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado!")));
    }

    @Override
    public Page<ClienteDTO> listar(Pageable pageable) {
        return repository.listar(pageable);
    }

    @Override
    public ClienteDTO salvar(ClienteDTO form) {
        Cliente cliente = new Cliente();
        cliente.setNome(form.getNome());
        cliente.setEmail(form.getEmail());
        cliente.setTelefone(form.getTelefone());

        repository.save(cliente);

        return form;
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO form) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(form.getNome());
        cliente.setEmail(form.getEmail());
        cliente.setTelefone(form.getTelefone());

        repository.save(cliente);

        return form;
    }

    @Override
    public void excluir(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Cliente não encontrado!"));

        if (cliente.getExcluido() == null) {
            cliente.setExcluido(LocalDateTime.now());
            repository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }
}
