package br.com.devBandeira.barber_pro.service;

import br.com.devBandeira.barber_pro.dto.AgendamentoDTO;
import br.com.devBandeira.barber_pro.exception.AgendamentoExistenteException;
import br.com.devBandeira.barber_pro.model.Agendamento;
import br.com.devBandeira.barber_pro.model.Barbeiro;
import br.com.devBandeira.barber_pro.model.Servico;
import br.com.devBandeira.barber_pro.model.Usuario;
import br.com.devBandeira.barber_pro.repository.AgendamentoRepository;
import br.com.devBandeira.barber_pro.repository.BarbeiroRepository;
import br.com.devBandeira.barber_pro.repository.ServicoRepository;
import br.com.devBandeira.barber_pro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoService(
            AgendamentoRepository agendamentoRepository,
            UsuarioRepository usuarioRepository,
            BarbeiroRepository barbeiroRepository,
            ServicoRepository servicoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.servicoRepository = servicoRepository;
    }

    public Agendamento criar(AgendamentoDTO dto) {
        // ✅ Verifica se o barbeiro já tem agendamento no horário
        agendamentoRepository.findByBarbeiroIdAndDataHora(dto.getBarbeiroId(), dto.getDataHora())
                .ifPresent(a -> {
                    throw new AgendamentoExistenteException("O barbeiro já possui um agendamento neste horário.");
                });

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Barbeiro barbeiro = barbeiroRepository.findById(dto.getBarbeiroId())
                .orElseThrow(() -> new IllegalArgumentException("Barbeiro não encontrado"));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(dto.getDataHora());
        agendamento.setUsuario(usuario);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setServico(servico);

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }
}