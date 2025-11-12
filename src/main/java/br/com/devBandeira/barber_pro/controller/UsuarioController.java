package br.com.devBandeira.barber_pro.controller;

import br.com.devBandeira.barber_pro.dto.UsuarioDTO;
import br.com.devBandeira.barber_pro.model.Usuario;
import br.com.devBandeira.barber_pro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(u -> new UsuarioDTO(u.getId(), u.getNome(), u.getUsername(), u.getRole()))
                .toList();
    }


    @PostMapping
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        return service.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
