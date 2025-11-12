package br.com.devBandeira.barber_pro.controller;

import br.com.devBandeira.barber_pro.model.Servico;
import br.com.devBandeira.barber_pro.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service){
        this.service = service;
    }

    @GetMapping
    public List<Servico> listarTodos(){
        return service.listarTodos();
    }

    @PostMapping
    public Servico salvar(@RequestBody @Valid Servico servico){
        return service.salvar(servico);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
