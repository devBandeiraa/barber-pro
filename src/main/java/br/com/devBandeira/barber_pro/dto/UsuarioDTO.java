package br.com.devBandeira.barber_pro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    private String username;

    private String role;

    public UsuarioDTO(Long id, String nome, String username, String role) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}