package br.com.devBandeira.barber_pro.service;

import br.com.devBandeira.barber_pro.model.Usuario;
import br.com.devBandeira.barber_pro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(long id){
        return repository.findById(id);
    }

    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }

    public void deletar(long id){
        repository.deleteById(id);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return repository.findByUsername(username);
    }

}
