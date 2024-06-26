package com.bistrobooking.controller.restaurante;

import com.bistrobooking.dto.restaurante.RestauranteDTO;
import com.bistrobooking.service.impl.restaurante.RestauranteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Restaurante")
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteServiceImpl service;

    public RestauranteController(RestauranteServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Busca um restaurante por ID")
    @GetMapping("{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable Long id) {
        RestauranteDTO restaurante = service.buscarPorId(id);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @Operation(summary = "Lista todos os restaurantes")
    @GetMapping
    public ResponseEntity<Page<RestauranteDTO>> listar() {
        Pageable pageable = Pageable.unpaged();
        Page<RestauranteDTO> restaurante = service.listar(pageable);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @Operation(summary = "Salva um novo restaurante")
    @PostMapping
    public ResponseEntity<RestauranteDTO> salvar(@RequestBody @Valid RestauranteDTO form) {
        RestauranteDTO restaurante = service.salvar(form);
        return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza informações de um restaurante")
    @PutMapping("{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid RestauranteDTO form) {
        RestauranteDTO restaurante = service.atualizar(id, form);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @Operation(summary = "Exclui informações de um restaurante")
    @DeleteMapping("{id}")
    public ResponseEntity<RestauranteDTO> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
