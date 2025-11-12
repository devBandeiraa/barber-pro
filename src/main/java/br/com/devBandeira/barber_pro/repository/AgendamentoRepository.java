package br.com.devBandeira.barber_pro.repository;

import br.com.devBandeira.barber_pro.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Optional<Agendamento> findByBarbeiroIdAndDataHora(Long barbeiroId, LocalDateTime dataHora);
}

