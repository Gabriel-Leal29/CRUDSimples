package com.usuarios.demo.DTO;

public class FilhoRequest {
    private int idade;
    private String nome;
    private Long idPai;

    public FilhoRequest(int idade, String nome, Long idPai) {
        this.idade = idade;
        this.nome = nome;
        this.idPai = idPai;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPai() {
        return idPai;
    }

    public void setIdPai(Long idPai) {
        this.idPai = idPai;
    }
}
