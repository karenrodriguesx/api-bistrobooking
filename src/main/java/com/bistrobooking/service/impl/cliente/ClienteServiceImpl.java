package com.bistrobooking.service.impl.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.entity.Cliente;
import com.bistrobooking.repository.cliente.ClienteRepository;
import com.bistrobooking.service.base.cliente.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return repository.buscarPorId(id).orElseThrow(() ->
                new IllegalArgumentException("Cliente não encontrado!"));
    }

    @Override
    public Page<ClienteDTO> listar(Pageable pageable) {
        return repository.listar(pageable);
    }

    @Override
    public ClienteDTO salvar(ClienteDTO form) {
        Cliente cliente = new Cliente();
        cliente.setNome(form.getNome());
        cliente.setEmail(form.getEmail().toLowerCase());
        cliente.setTelefone(form.getTelefone());

        Cliente clienteEmail = repository.findByEmail(form.getEmail().toLowerCase()).orElse(null);

        if (clienteEmail != null) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        } else repository.save(cliente);

        return form;
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO form) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Cliente não encontrado!"));

        if (cliente.getExcluido() == null) {
            cliente.setId(form.getId());
            cliente.setNome(form.getNome());
            cliente.setEmail(form.getEmail().toLowerCase());
            cliente.setTelefone(form.getTelefone());

            repository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

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
