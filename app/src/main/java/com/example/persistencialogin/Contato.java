package com.example.persistencialogin;

import java.io.Serializable;

public class Contato implements Serializable {
    private String nome, email, usuario, senha;

    public Contato(String nome, String email, String usuario, String senha) {
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
