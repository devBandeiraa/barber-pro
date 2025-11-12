package br.com.devBandeira.barber_pro.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    private Long id;

    @NotNull(message = "A data e hora do agendamento são obrigatórias.")
    @Future(message = "A data e hora devem estar no futuro.")
    private LocalDateTime dataHora;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotNull(message = "O ID do barbeiro é obrigatório.")
    private Long barbeiroId;

    @NotNull(message = "O ID do serviço é obrigatório.")
    private Long servicoId;

    public AgendamentoDTO(Long id, LocalDateTime dataHora, Long usuarioId, Long barbeiroId, Long servicoId) {
        this.id = id;
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
        this.barbeiroId = barbeiroId;
        this.servicoId = servicoId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getBarbeiroId() {
        return barbeiroId;
    }

    public Long getServicoId() {
        return servicoId;
    }
}
