package com.bistrobooking.controller.restaurante;

import com.bistrobooking.dto.restaurante.RestauranteDTO;
import com.bistrobooking.service.impl.restaurante.RestauranteServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteServiceImpl service;

    public RestauranteController(RestauranteServiceImpl service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable Long id) {
        RestauranteDTO restaurante = service.buscarPorId(id);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<RestauranteDTO>> listar() {
        Pageable pageable = Pageable.unpaged();
        Page<RestauranteDTO> restaurante = service.listar(pageable);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> salvar(@RequestBody RestauranteDTO form) {
        RestauranteDTO restaurante = service.salvar(form);
        return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody RestauranteDTO form) {
        RestauranteDTO restaurante = service.atualizar(id, form);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RestauranteDTO> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
