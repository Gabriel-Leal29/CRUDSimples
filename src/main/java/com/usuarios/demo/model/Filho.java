package com.usuarios.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "filho")
public class Filho extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_filho;

    @ManyToOne
    @JoinColumn(name = "pai_id")
    @JsonBackReference
    private Pai pai;

    public Filho() {}
    public Filho(int idade, String nome, Pai pai) {
        super(idade,  nome);
        this.pai = pai;
    }
    public Long getId() {
        return id_filho;
    }
    public Pai getPai() {
        return pai;
    }
    public void setPai(Pai pai) {
        this.pai = pai;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Filho filho)) return false;
        return Objects.equals(id_filho, filho.id_filho);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_filho);
    }
}
