package com.usuarios.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
    @Column(name = "nome")
    private String nome;

    @Column(name="idade")
    private int idade;

    public Pessoa() {} // construtor padrão

    public Pessoa(int idade, String nome) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
