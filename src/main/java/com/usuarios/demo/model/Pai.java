package com.usuarios.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pai")
public class Pai extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pai;

    @OneToMany(mappedBy = "pai",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Filho> filhos = new ArrayList<>();

    public Pai() {}
    public Pai(int idade, String nome) {
        super(idade, nome);
    }

    public void setIdPai(Long id_pai) {
        this.id_pai = id_pai;
    }
    public Long getId() {
        return id_pai;
    }
    public List<Filho> getFilhos() {
        return filhos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pai pai)) return false;
        return Objects.equals(id_pai, pai.id_pai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pai);
    }
}
