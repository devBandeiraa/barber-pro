package br.com.devBandeira.barber_pro.service;

import br.com.devBandeira.barber_pro.model.Servico;
import br.com.devBandeira.barber_pro.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository){
        this.repository = repository;
    }

    public List<Servico> listarTodos(){
        return repository.findAll();
    }

    public Servico salvar(Servico servico){
        return repository.save(servico);
    }

    public void deletar(long id){
        repository.deleteById(id);
    }
}
