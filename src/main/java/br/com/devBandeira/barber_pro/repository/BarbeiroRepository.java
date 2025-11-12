package br.com.devBandeira.barber_pro.repository;

import br.com.devBandeira.barber_pro.model.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}
