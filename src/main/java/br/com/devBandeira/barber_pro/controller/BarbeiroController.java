package br.com.devBandeira.barber_pro.controller;

import br.com.devBandeira.barber_pro.model.Barbeiro;
import br.com.devBandeira.barber_pro.service.BarbeiroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    private final BarbeiroService service;

    public BarbeiroController(BarbeiroService service){
        this.service = service;
    }

    @GetMapping
    public List<Barbeiro> listarTodos(){
        return service.listarTodos();
    }

    @PostMapping
    public Barbeiro salvar(@RequestBody @Valid Barbeiro barbeiro){
        return service.salvar(barbeiro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        service.deletar(id);
    }
}
