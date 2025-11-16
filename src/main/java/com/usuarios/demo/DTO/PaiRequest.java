package com.usuarios.demo.DTO;

import com.usuarios.demo.model.Filho;

import java.util.ArrayList;
import java.util.List;

public class PaiRequest {
    private String nome;
    private int idade;
    private List<Long> idFilhos = new ArrayList<>();

    public PaiRequest(){};
    public PaiRequest(String nome, int idade) {
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

    public void adicionarFilho(Long id) {
        idFilhos.add(id);
    }

    public List<Long> getFilhos() {
        return idFilhos;
    }
}
