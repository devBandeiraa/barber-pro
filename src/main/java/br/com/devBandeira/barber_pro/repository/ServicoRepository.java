package br.com.devBandeira.barber_pro.repository;

import br.com.devBandeira.barber_pro.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
