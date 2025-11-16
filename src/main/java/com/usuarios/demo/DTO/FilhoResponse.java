package com.usuarios.demo.DTO;

public class FilhoResponse {

    private Long id;
    private String nome;
    private int idade;
    private String nomePai;

    public Long getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}
