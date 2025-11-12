package br.com.devBandeira.barber_pro.controller;

import br.com.devBandeira.barber_pro.dto.AgendamentoDTO;
import br.com.devBandeira.barber_pro.exception.AgendamentoExistenteException;
import br.com.devBandeira.barber_pro.model.Agendamento;
import br.com.devBandeira.barber_pro.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody AgendamentoDTO dto) {
        try {
            Agendamento novo = service.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novo);
        } catch (AgendamentoExistenteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Agendamento> listarTodos() {
        return service.listarTodos();
    }
}