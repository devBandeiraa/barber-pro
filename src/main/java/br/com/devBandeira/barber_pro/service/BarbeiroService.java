package br.com.devBandeira.barber_pro.service;

import br.com.devBandeira.barber_pro.model.Barbeiro;
import br.com.devBandeira.barber_pro.repository.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository repository;

    public BarbeiroService(BarbeiroRepository repository){
        this.repository = repository;
    }

    public List<Barbeiro> listarTodos(){
        return repository.findAll();
    }

    public Barbeiro salvar(Barbeiro barbeiro){
        return repository.save(barbeiro);
    }

    public void deletar(long id){
        repository.deleteById(id);
    }

}
