package com.bistrobooking.controller.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.service.impl.cliente.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cliente")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteServiceImpl service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Busca um cliente por ID")
    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        ClienteDTO cliente = service.buscarPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Lista todos os clientes")
    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> listar() {
        Pageable pageable = Pageable.unpaged();
        Page<ClienteDTO> cliente = service.listar(pageable);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Salva um novo cliente")
    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody @Valid ClienteDTO form) {
        ClienteDTO cliente = service.salvar(form);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza informações de um cliente")
    @PutMapping("{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDTO form) {
        ClienteDTO cliente = service.atualizar(id, form);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Exclui o cadastro do cliente")
    @DeleteMapping("{id}")
    public ResponseEntity<ClienteDTO> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
