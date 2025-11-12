package br.com.devBandeira.barber_pro.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Barbeiro {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    private String especialidade;

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
