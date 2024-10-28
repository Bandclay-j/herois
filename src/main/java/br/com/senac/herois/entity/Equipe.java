package br.com.senac.herois.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "equipe")
    @JsonBackReference
    private List<SuperHeroi> superHeroi = new ArrayList<>();

    public Equipe() {
    }

    public Equipe(int id, String nome, List<SuperHeroi> superHeroi) {
        this.id = id;
        this.nome = nome;
        this.superHeroi = superHeroi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<SuperHeroi> getSuperHeroi() {
        return superHeroi;
    }

    public void setSuperHeroi(List<SuperHeroi> superHeroi) {
        this.superHeroi = superHeroi;
    }
}
