package com.bistrobooking.controller.reserva;

import com.bistrobooking.dto.reserva.ReservaDTO;
import com.bistrobooking.dto.reserva.ReservaFetchDTO;
import com.bistrobooking.dto.reserva.ReservaListDTO;
import com.bistrobooking.service.impl.reserva.ReservaServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaServiceImpl service;

    public ReservaController(ReservaServiceImpl service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<ReservaFetchDTO> buscarPorId(@PathVariable Long id) {
        ReservaFetchDTO reserva = service.buscarPorId(id);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ReservaListDTO>> listar() {
        Pageable pageable = Pageable.unpaged();
        Page<ReservaListDTO> reserva = service.listar(pageable);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@RequestBody ReservaDTO form) {
        ReservaDTO reserva = service.salvar(form);
        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReservaDTO> atualizar(@PathVariable Long id, @RequestBody ReservaDTO form) {
        ReservaDTO reserva = service.atualizar(id, form);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ReservaDTO> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
