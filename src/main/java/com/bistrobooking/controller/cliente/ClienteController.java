package com.bistrobooking.controller.cliente;

import com.bistrobooking.dto.cliente.ClienteDTO;
import com.bistrobooking.service.impl.cliente.ClienteServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteServiceImpl service;

    public ClienteController(ClienteServiceImpl service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        ClienteDTO cliente = service.buscarPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> listar() {
        Pageable pageable = Pageable.unpaged();
        Page<ClienteDTO> cliente = service.listar(pageable);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO form) {
        ClienteDTO cliente = service.salvar(form);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteDTO form) {
        ClienteDTO cliente = service.atualizar(id, form);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClienteDTO> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
